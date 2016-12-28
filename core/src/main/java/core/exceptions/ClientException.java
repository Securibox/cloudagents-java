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

// TODO: Auto-generated Javadoc
/**
 * The Class ClientException.
 */
public class ClientException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8193885700242302897L;
	
	/**
	 * Instantiates a new client exception.
	 */
	public ClientException(){		
		super();
	}
	
	/**
	 * Instantiates a new client exception.
	 *
	 * @param message the message
	 */
	public ClientException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new client exception.
	 *
	 * @param e the e
	 */
	public ClientException(Exception e) {
		super(e);
	}
}
