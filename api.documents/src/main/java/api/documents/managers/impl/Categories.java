package api.documents.managers.impl;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import api.documents.beans.Agent;
import api.documents.beans.Category;
import api.documents.managers.CategoryManager;
import core.Client;
import core.Response;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;
import core.impl.Utils;

public class Categories implements CategoryManager {

	private static String path = "categories/";
	
	public List<Category> ListCategories(String culture) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		UriParameters pars = new UriParameters();
		pars.put("culture", culture);
		Response r = c.get(path + "?" + pars.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Category>>(){});
	}

	public List<Agent> ListAgentsByCategory(String categoryId) throws ClientException, ResponseException {

		if(Utils.nullOrEmpty(categoryId))
			throw new IllegalArgumentException("Null or empty categoryId was provided");
		
		Client c = ApiClient.getClient();
		
		Response r = c.get(path + categoryId + "/agents");
		return c.deserialize(r.getBody(), new TypeReference<List<Agent>>(){});
	}

}
