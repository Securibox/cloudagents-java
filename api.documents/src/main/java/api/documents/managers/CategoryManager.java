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
