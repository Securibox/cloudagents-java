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

package api.documents.managers;

import java.util.List;

import api.documents.beans.Agent;
import api.documents.beans.Category;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CategoryManager.
 */
public interface CategoryManager {
	 
 	/**
 	 * List categories.
 	 *
 	 * @param culture the culture
 	 * @return the list
 	 * @throws ClientException the client exception
 	 * @throws ResponseException the response exception
 	 */
 	public List<Category> ListCategories(String culture) throws ClientException, ResponseException;
	 
 	/**
 	 * List agents by category.
 	 *
 	 * @param categoryId the category id
 	 * @return the list
 	 * @throws ClientException the client exception
 	 * @throws ResponseException the response exception
 	 */
 	public List<Agent> ListAgentsByCategory(String categoryId) throws ClientException, ResponseException;
}
