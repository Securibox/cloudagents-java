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

package core;

// TODO: Auto-generated Javadoc
/**
 * The Interface Response.
 */
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
