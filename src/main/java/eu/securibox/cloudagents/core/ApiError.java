package eu.securibox.cloudagents.core;

/**
 * The Interface ApiError.
 */
public interface ApiError {

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	int getCode();

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMessage();

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	String getDescription();
}