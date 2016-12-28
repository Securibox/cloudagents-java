  /**
   * Copyright (C) 2016 Securibox
   * 
   * This program is free software: you can redistribute it and/or modify 
   * it under the terms of the GNU General Public License as published by 
   * the Free Software Foundation, either version 3 of the License, or 
   * (at your option) any later version.
   * 
   * This program is distributed in the hope that it will be useful, 
   * but WITHOUT ANY WARRANTY; without even the implied warranty of 
   * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
   * GNU General Public License for more details.
   * 
   * You should have received a copy of the GNU General Public License 
   * along with this program.  If not, see <http://www.gnu.org/licenses/>.
   */

package core.exceptions;

import core.ApiError;
import core.Response;

// TODO: Auto-generated Javadoc
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
