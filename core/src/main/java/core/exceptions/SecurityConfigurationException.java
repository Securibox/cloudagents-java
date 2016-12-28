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
 * The Class SecurityConfigurationException.
 */
public class SecurityConfigurationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5055980709100658120L;
	
	/**
	 * Instantiates a new security configuration exception.
	 */
	public SecurityConfigurationException(){
		super();
	}
	
	/**
	 * Instantiates a new security configuration exception.
	 *
	 * @param message the message
	 */
	public SecurityConfigurationException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new security configuration exception.
	 *
	 * @param e the e
	 */
	public SecurityConfigurationException(Exception e) {
		super(e);
	}
	
}
