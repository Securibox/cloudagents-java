package core.impl;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.fluent.Executor;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

import core.SecurityConfiguration;
import core.TrustStore;
import core.exceptions.SecurityConfigurationException;

// TODO: Auto-generated Javadoc
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

}
