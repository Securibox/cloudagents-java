package eu.securibox.cloudagents.core.http;


import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import eu.securibox.cloudagents.core.Response;

public class HttpResponse implements Response {

	String body = null;
	String responseMessage = null;
	int statusCode;

	public HttpResponse(org.apache.hc.client5.http.fluent.Response response) throws IOException {
		if (response == null) {
			throw new IOException("No Response object was returned by the client.");
		}
		// HttpClient 5: handleResponse reads status and body in one pass
		// and releases the connection automatically.
		response.handleResponse(resp -> {
			this.statusCode = resp.getCode();
			this.responseMessage = resp.getReasonPhrase();
			this.body = readEntity(resp.getEntity());
			return null;
		});
	}

	private static String readEntity(HttpEntity entity) throws IOException, org.apache.hc.core5.http.ParseException {
		if (entity == null) {
			// e.g. 204 No Content
			return "";
		}
		// Uses the charset from the Content-Type header, UTF-8 if none is given.
		return EntityUtils.toString(entity, StandardCharsets.UTF_8);
	}

	public String getBody() {
		return this.body;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public String getResponseMessage() {
		return this.responseMessage;
	}

}