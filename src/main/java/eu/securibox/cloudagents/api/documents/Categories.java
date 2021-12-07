  /**
   * Copyright (C) 2021 Securibox
   * 
   */

package eu.securibox.cloudagents.api.documents;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.Response;
import eu.securibox.cloudagents.core.exceptions.*;
import eu.securibox.cloudagents.core.http.*;
import eu.securibox.cloudagents.core.Utils;

import eu.securibox.cloudagents.api.documents.beans.Agent;
import eu.securibox.cloudagents.api.documents.beans.Category;
/**
 * Wrapper for the Categories related methods.
 *
 */
public class Categories {

	private static String path = "categories/";
	
	/**
	 * Lists the agents categories.
	 * @param culture The culture of the returned information.
	 * @return A list of agent categories
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	* @throws UnsupportedEncodingException
	*    		An Unsupported Encoding Exception
	 */
	public List<Category> ListCategories(String culture) throws ClientException, ResponseException, UnsupportedEncodingException {
		Client c = ApiClient.getClient();
		
		UriParameters pars = new UriParameters();
		pars.put("culture", culture);
		Response r = c.get(path + "?" + pars.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Category>>(){});
	}

	/**
	 * Lists the agents belonging to a provided category
	 * @param categoryId The category identifier to filter the agents
	 * @return A list of agents
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	 */
	public List<Agent> ListAgentsByCategory(String categoryId) throws ClientException, ResponseException {

		if(Utils.nullOrEmpty(categoryId))
			throw new IllegalArgumentException("Null or empty categoryId was provided");
		
		Client c = ApiClient.getClient();
		
		Response r = c.get(path + categoryId + "/agents");
		return c.deserialize(r.getBody(), new TypeReference<List<Agent>>(){});
	}

}
