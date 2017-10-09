package eu.securibox.cloudagents.core.configuration;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.fluent.Executor;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;

import eu.securibox.cloudagents.core.SecurityConfiguration;
import eu.securibox.cloudagents.core.TrustStore;
import eu.securibox.cloudagents.core.exceptions.SecurityConfigurationException;
import eu.securibox.cloudagents.core.Utils;
import eu.securibox.cloudagents.core.auth.jwt.JWTCreator;
import eu.securibox.cloudagents.core.auth.jwt.algorithms.Algorithm;
import eu.securibox.cloudagents.core.auth.jwt.exceptions.JWTCreationException;

//TODO: Auto-generated Javadoc
/**
* The Class SSLConfiguration.
*/
public class SSLConfiguration implements SecurityConfiguration {

	/** The executor. */
	private Executor executor;

	/** The preemptive auth. */
	private boolean preemptiveAuth = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.SecurityConfiguration#getExecutor()
	 */
	public Executor getExecutor() {
		return this.executor;
	}

	/**
	 * Instantiates a new SSL configuration.
	 */
	private SSLConfiguration() {
	}

	/**
	 * Create a new SSL configuration using basic authentication. 
	 * If no TrustStore is specified, Java VM trust store will be used.
	 *
	 * @param store
	 *            the store
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the security configuration
	 * @throws SecurityConfigurationException
	 *             the security configuration exception
	 */
	public static SecurityConfiguration Basic(TrustStore store, String username, String password)
			throws SecurityConfigurationException {

		if (Utils.nullOrEmpty(username))
			throw new IllegalArgumentException("No username was provided for basic authentication.");
		if (Utils.nullOrEmpty(password))
			throw new IllegalArgumentException("No password was provided for basic authentication.");

		try {

			SSLConfiguration cfg = new SSLConfiguration();

			// Getting SSL context from the custom store (if needed)
			SSLContextBuilder contextBuilder = SSLConfiguration.getSSLContextBuilder(store);

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(contextBuilder.build(),
					new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());

			HttpClientBuilder clientBuilder = HttpClients.custom();
			clientBuilder.setSSLSocketFactory(sslsf);

			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
					new UsernamePasswordCredentials(username, password));
			clientBuilder.setDefaultCredentialsProvider(credsProvider);

			clientBuilder.setConnectionManagerShared(true); // This avoid the
			// underlying
			// HttpClient to be
			// garbage collected
			// (or connection
			// pool to be
			// cancelled);

			CloseableHttpClient httpClient = clientBuilder.build(); // TLS

			cfg.executor = Executor.newInstance(httpClient);
			cfg.preemptiveAuth = true;
			return cfg;

		} catch (NoSuchAlgorithmException e) {
			throw new SecurityConfigurationException(e);
		} catch (KeyStoreException e) {
			throw new SecurityConfigurationException(e);
		} catch (CertificateException e) {
			throw new SecurityConfigurationException(e);
		} catch (IOException e) {
			throw new SecurityConfigurationException(e);
		} catch (KeyManagementException e) {
			throw new SecurityConfigurationException(e);
		}
	}

	/**
	 * Create a new SSL configuration using client certificate authentication. 
	 * If no TrustStore is specified, Java VM trust store will be used.
	 *
	 * @param store
	 *            the store
	 * @param keyStoreFilename
	 *            the key store filename
	 * @param keyStorePassword
	 *            the key store password
	 * @param keyStorePrivateKeyPassword
	 *            the key store private key password
	 * @return the security configuration
	 * @throws SecurityConfigurationException
	 *             the security configuration exception
	 */
	public static SecurityConfiguration ClientCertificate(TrustStore store, String keyStoreFilename,
			String keyStorePassword, String keyStorePrivateKeyPassword) throws SecurityConfigurationException {

		if (Utils.nullOrEmpty(keyStoreFilename))
			throw new IllegalArgumentException(
					"No keyStore filename was provided for client certificate authentication.");
		if (Utils.nullOrEmpty(keyStorePassword))
			keyStorePassword = "";
		if (Utils.nullOrEmpty(keyStorePrivateKeyPassword))
			keyStorePrivateKeyPassword = "";

		try {
			SSLConfiguration cfg = new SSLConfiguration();

			// Getting SSL context from the custom store (if needed)
			SSLContextBuilder contextBuilder = SSLConfiguration.getSSLContextBuilder(store);

			contextBuilder.loadKeyMaterial(new File(keyStoreFilename), keyStorePassword.toCharArray(),
					keyStorePrivateKeyPassword.toCharArray());

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(contextBuilder.build(),
					new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
			HttpClientBuilder clientBuilder = HttpClients.custom();
			clientBuilder.setSSLSocketFactory(sslsf);

			clientBuilder.setConnectionManagerShared(true); // This avoid the
			// underlying
			// HttpClient to be
			// garbage collected
			// (or connection
			// pool to be
			// cancelled);

			CloseableHttpClient httpClient = clientBuilder.build(); // TLS

			cfg.executor = Executor.newInstance(httpClient);

			return cfg;
		} catch (NoSuchAlgorithmException e) {
			throw new SecurityConfigurationException(e);
		} catch (KeyStoreException e) {
			throw new SecurityConfigurationException(e);
		} catch (CertificateException e) {
			throw new SecurityConfigurationException(e);
		} catch (IOException e) {
			throw new SecurityConfigurationException(e);
		} catch (KeyManagementException e) {
			throw new SecurityConfigurationException(e);
		} catch (UnrecoverableKeyException e) {
			throw new SecurityConfigurationException(e);
		}
	}

	/**
	 * Create a new SSL configuration using JWT authentication. 
	 * If no TrustStore is specified, Java VM trust store will be used.
	 *
	 * @param store
	 *            the store
	 * @param publicKeyFilePath
	 *            The public key file path (PEM Format)
	 *            openssl rsa -in privatekey.pem -out publickey.pem -pubout
	 * @param privateKeyFilePath
	 *            The private key file path (PKCS#8)
	 *            openssl pkcs8 -in privatekey.pem -topk8 -out privatekey-pkcs8.pem
	 * @param privateKeyPassword
	 *            The private key password          
	 * @return the security configuration
	 * @throws Exception 
	 * @throws InvalidKeySpecException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeyException 
	 */	
	public static SecurityConfiguration JWT(TrustStore store, String publicKeyFilePath, String privateKeyFilePath, String privateKeyPassword) throws Exception {
		
		try {

			SSLConfiguration cfg = new SSLConfiguration();

			// Getting SSL context from the custom store (if needed)
			SSLContextBuilder contextBuilder = SSLConfiguration.getSSLContextBuilder(store);

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(contextBuilder.build(),
					new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());

			HttpClientBuilder clientBuilder = HttpClients.custom();
			
			RSAPrivateKey privateKey = loadRSAPrivateKeyFromFile(privateKeyFilePath, privateKeyPassword);//Get the key instance
			RSAPublicKey publicKey = loadRSAPublicKeyFromFile(publicKeyFilePath);
			
	
			Calendar calendar = Calendar.getInstance();
			long t= calendar.getTimeInMillis();
			Date date = new Date(t);
			Date expiresAt = new Date(t + (60 * 6000));
			
			Algorithm JwtAlgorithm = Algorithm.RSA256(publicKey, privateKey);
			String token = JWTCreator.init()
					.withIssuer("SCA API SDK")
			        .withIssuedAt(date)
			        .withExpiresAt(expiresAt)
			        .withAudience("https://sca-multitenant.securibox.eu")
			        .sign(JwtAlgorithm);
			
			Header jwtHeader = new BasicHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
			List<Header> headers = new ArrayList<Header>();
			headers.add(jwtHeader);
			
			clientBuilder.setDefaultHeaders(headers);
			clientBuilder.setSSLSocketFactory(sslsf);
			clientBuilder.setConnectionManagerShared(true);

			CloseableHttpClient httpClient = clientBuilder.build(); // TLS

			cfg.executor = Executor.newInstance(httpClient);
			cfg.preemptiveAuth = true;
			return cfg;
			
		} catch (JWTCreationException e){
			throw new SecurityConfigurationException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new SecurityConfigurationException(e);
		} catch (KeyStoreException e) {
			throw new SecurityConfigurationException(e);
		} catch (CertificateException e) {
			throw new SecurityConfigurationException(e);
		} catch (IOException e) {
			throw new SecurityConfigurationException(e);
		} catch (KeyManagementException e) {
			throw new SecurityConfigurationException(e);
		}
	}
	
	/**
	 * Gets the SSL context builder.
	 *
	 * @param store
	 *            the store
	 * @return the SSL context builder
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 * @throws KeyStoreException
	 *             the key store exception
	 * @throws CertificateException
	 *             the certificate exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static SSLContextBuilder getSSLContextBuilder(TrustStore store)
			throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {

		SSLContextBuilder contextBuilder = new SSLContextBuilder();

		if (store != null) {
			String fileName = store.getFilename();
			String password = store.getPassword();

			if (Utils.nullOrEmpty(password))
				password = "";
			contextBuilder.loadTrustMaterial(new File(fileName), password.toCharArray());
		}
		return contextBuilder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.SecurityConfiguration#userPreemptiveAuth()
	 */
	public boolean userPreemptiveAuth() {
		return this.preemptiveAuth;
	}
	

	
	public static RSAPrivateKey loadRSAPrivateKeyFromFile(String filePath, String privateKeyPassword) throws Exception {
	    String privateKeyPEM = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	    privateKeyPEM = privateKeyPEM
	            .replace("-----BEGIN PRIVATE KEY-----", "")
	            .replace("-----END PRIVATE KEY-----", "")
	            .replace("-----BEGIN ENCRYPTED PRIVATE KEY-----", "")
	            .replace("-----END ENCRYPTED PRIVATE KEY-----", "")	            
	            .replaceAll("\\s", "");

	    // decode to get the binary DER representation
	    byte[] privateKeyDER = Base64.getDecoder().decode(privateKeyPEM);
	    PKCS8EncodedKeySpec privSpec = null;
	    
        if(privateKeyPassword != null && !privateKeyPassword.isEmpty()){
            EncryptedPrivateKeyInfo ePKInfo = new EncryptedPrivateKeyInfo(privateKeyDER);
            Cipher cipher = Cipher.getInstance(ePKInfo.getAlgName());
            PBEKeySpec pbeKeySpec = new PBEKeySpec(privateKeyPassword.toCharArray());
            SecretKeyFactory skFac = SecretKeyFactory.getInstance(ePKInfo.getAlgName());
            Key pbeKey = skFac.generateSecret(pbeKeySpec);
            AlgorithmParameters algParams = ePKInfo.getAlgParameters();
            cipher.init(Cipher.DECRYPT_MODE, pbeKey, algParams);
            privSpec = ePKInfo.getKeySpec(cipher);
        }else{
        	privSpec = new PKCS8EncodedKeySpec(privateKeyDER);
        }

	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    RSAPrivateKey privateKey = (RSAPrivateKey)keyFactory.generatePrivate(privSpec);
	    return privateKey;
	}
	
	public static RSAPublicKey loadRSAPublicKeyFromFile(String filePath) throws Exception {
	    String publicKeyPEM = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

	    publicKeyPEM = publicKeyPEM
	            .replace("-----BEGIN PUBLIC KEY-----", "")
	            .replace("-----END PUBLIC KEY-----", "")
	            .replaceAll("\\s", "");

	    // decode to get the binary DER representation
	    byte[] publicKeyDER = Base64.getDecoder().decode(publicKeyPEM);

	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    RSAPublicKey publicKey = (RSAPublicKey)keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyDER));
	    return publicKey;
	}	

}