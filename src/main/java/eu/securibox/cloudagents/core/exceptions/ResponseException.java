package eu.securibox.cloudagents.core.exceptions;

import eu.securibox.cloudagents.core.ApiError;
import eu.securibox.cloudagents.core.Response;

//TODO: Auto-generated Javadoc
/**
* The Class ResponseException.
*/
public class ResponseException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2573054887060799680L;

	/** The response. */
	protected Response response = null;
	
	/** The api error. */
	protected ApiError apiError = null;
	
	/**
	 * Instantiates a new response exception.
	 *
	 * @param response the response
	 * @param apiError the api error
	 */
	public ResponseException(Response response, ApiError apiError){
		this.response = response;
		this.apiError = apiError;
	}
	
	/**
	 * Instantiates a new response exception.
	 *
	 * @param response the response
	 * @param apiError the api error
	 * @param e the e
	 */
	public ResponseException(Response response, ApiError apiError, Exception e) {
		super(e);
		this.response = response;
		this.apiError = apiError;
	}

	/**
	 * Instantiates a new response exception.
	 *
	 * @param response the response
	 */
	public ResponseException(Response response) {
		this.response = response;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Gets the api error.
	 *
	 * @return the api error
	 */
	public ApiError getApiError() {
		return this.apiError; 
	}
}