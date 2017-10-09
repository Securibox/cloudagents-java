package eu.securibox.cloudagents.core.http;

import eu.securibox.cloudagents.core.TrustStore;
import eu.securibox.cloudagents.core.Utils;

//TODO: Auto-generated Javadoc
/**
* The Class HttpTrustStore.
*/
public class HttpTrustStore implements TrustStore {

	/** The filename. */
	private String filename;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new http trust store.
	 *
	 * @param filename
	 *            the filename
	 * @param password
	 *            the password
	 */
	public HttpTrustStore(String filename, String password) {
		if (Utils.nullOrEmpty(filename))
			throw new IllegalArgumentException("The filename cannot be null or empty");
		this.filename = filename;
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.TrustStore#getFilename()
	 */
	public String getFilename() {
		return this.filename;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.TrustStore#getPassword()
	 */
	public String getPassword() {
		return this.password;
	}

}