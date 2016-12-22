package core.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import core.ApiError;
import core.Client;
import core.Response;
import core.SecurityConfiguration;
import core.TrustStore;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;
import core.exceptions.SecurityConfigurationException;

public class HttpClient implements Client {

	protected Executor executor;
	protected String baseUrl;
	protected ObjectMapper mapper;
	
	public static Client FromConfigFile(String configurationFile) throws SecurityConfigurationException{
		if(Utils.nullOrEmpty(configurationFile))
			throw new IllegalArgumentException("No configurationFile was provided.");
		
		Properties p = Configuration.getProperties(configurationFile);
		
		TrustStore store = null;
		SecurityConfiguration cfg = null;
		
		String trustFile = p.getProperty("truststore.filename");
		if(!Utils.nullOrEmpty(trustFile)){
			store = new HttpTrustStore(trustFile, p.getProperty("truststore.password"));
		}
		
		String basicUser = p.getProperty("client.username");
		String keyStoreFile = p.getProperty("keystore.filename");
		if(!Utils.nullOrEmpty(basicUser)){
			cfg = SSLConfiguration.Basic(store, basicUser, p.getProperty("client.password"));
		}
		else if(!Utils.nullOrEmpty(keyStoreFile)){
			cfg = SSLConfiguration.ClientCertificate(store, keyStoreFile, p.getProperty("keystore.password"), p.getProperty("keystore.privatekeypassword"));
		}
		else{
			throw new IllegalArgumentException("The configuration file is not correctly filled. Either 'client.username' or 'keystore.filename' must be provided.");
		}
		
		return new HttpClient(p.getProperty("client.baseUrl"), cfg);
	}

	public HttpClient(String baseUrl, SecurityConfiguration configuration) {

		if (Utils.nullOrEmpty(baseUrl))
			throw new IllegalArgumentException("No base Url was provided.");
		if (!baseUrl.contains("https://"))
			throw new IllegalArgumentException(
					"The base Url must start with 'https://'. Other protocols are not supported.");

		this.baseUrl = (baseUrl.substring(baseUrl.length() - 1).equals("/")) ? baseUrl : baseUrl + "/";
		
		// Getting the executor from the SSLConfiguration
		this.executor = configuration.getExecutor();
		
		// If needed, configure preemptive authentication
		if (configuration.userPreemptiveAuth()) {
			String hostString = this.baseUrl.substring(0,
					this.baseUrl.indexOf("/", this.baseUrl.indexOf("://") + 3));
			HttpHost host = HttpHost.create(hostString);
			executor.authPreemptive(host);
		}
		
		// Instancing the JSON mapper (jackson library)
		this.mapper = new ObjectMapper();
		
		this.mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true); 
        // Avoid having to annotate the Person class
        // Requires Java 8, pass -parameters to javac
        // and jackson-module-parameter-names as a dependency
        this.mapper.registerModule(new ParameterNamesModule());
 
        // make private fields of Person visible to Jackson
        this.mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.mapper.setDateFormat(formatter);
        
        // If the API object contains some unknown fields, jackson will not raise an exception.
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public Response get(String path) throws ClientException, ResponseException {
		return this.execute(HttpMethod.GET, path, null);
	}

	public Response post(String path) throws ClientException, ResponseException {
		return this.execute(HttpMethod.POST, path, null);
	}

	public Response post(String path, String payload) throws ClientException, ResponseException {
		return this.execute(HttpMethod.POST, path, payload);
	}

	public Response put(String path) throws ClientException, ResponseException {
		return this.execute(HttpMethod.PUT, path, null);
	}

	public Response put(String path, String payload) throws ClientException, ResponseException {
		return this.execute(HttpMethod.PUT, path, payload);
	}

	public Response delete(String path) throws ClientException, ResponseException {
		return this.execute(HttpMethod.DELETE, path, null);
	}

	private Response execute(HttpMethod method, String path, String payload) throws ResponseException, ClientException {

		org.apache.http.client.fluent.Response resp = null;
		try {
			switch (method) {
			case GET:
				resp = this.executor.execute(Request.Get(this.baseUrl + Utils.clearPath(path)));
				break;
			case POST:
				Request request = Request.Post(this.baseUrl + Utils.clearPath(path));
				if (payload != null)
					request.bodyString(payload, ContentType.APPLICATION_JSON);
				resp = this.executor.execute(request);
				break;
			case PUT:
				Request req = Request.Put(this.baseUrl + Utils.clearPath(path));
				if (payload != null)
					req.bodyString(payload, ContentType.APPLICATION_JSON);
				resp = this.executor.execute(req);
				break;
			case DELETE:
				resp = this.executor.execute(Request.Delete(this.baseUrl + Utils.clearPath(path)));
				break;
			default:
				throw new IllegalArgumentException("The HttpMethod " + method + " is not supported");
			}
			Response response = new HttpResponse(resp);
			int status = response.getStatusCode();
			if (status < 200 || status > 299) {
				ApiError error = null;
				try {
					error = (ApiError) this.deserialize(response.getBody(), new TypeReference<HttpApiError>(){}); 
				} catch (ClientException e) {
					throw new ResponseException(response);
				}
				throw new ResponseException(response, error);
			}
			return response;

		} catch (ClientProtocolException e) {
			throw new ClientException(e);
		} catch (IOException e) {
			throw new ClientException(e);
		}
	}

	public String serialize(Object obj) throws ClientException {
		try {
			return this.mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			throw new ClientException(e);
		} catch (JsonMappingException e) {
			throw new ClientException(e);
		} catch (IOException e) {
			throw new ClientException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T deserialize(String s,TypeReference<T> type) throws ClientException {
		try {			
			T out = (T) this.mapper.readValue(s, type);
			return out;
		} catch (JsonParseException e) {
			throw new ClientException(e);
		} catch (JsonMappingException e) {
			throw new ClientException(e);
		} catch (IOException e) {
			throw new ClientException(e);
		}
	}

	public <T> void addSerializer(Class<? extends T> type, JsonSerializer<T> ser) {
		SimpleModule module = new SimpleModule();
		module.addSerializer(type, ser);
		this.mapper.registerModule(module);
	}	
}
