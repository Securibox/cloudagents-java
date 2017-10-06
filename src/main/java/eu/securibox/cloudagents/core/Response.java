package eu.securibox.cloudagents.core;

public interface Response {

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public String getBody();

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public int getStatusCode();

	/**
	 * Gets the response message.
	 *
	 * @return the response message
	 */
	public String getResponseMessage();
}
