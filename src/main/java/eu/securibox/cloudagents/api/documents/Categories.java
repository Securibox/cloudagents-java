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

package eu.securibox.cloudagents.api.documents;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.Response;
import eu.securibox.cloudagents.core.exceptions.*;
import eu.securibox.cloudagents.core.http.*;
import eu.securibox.cloudagents.core.Utils;

import eu.securibox.cloudagents.api.documents.beans.Agent;
import eu.securibox.cloudagents.api.documents.beans.Category;

public class Categories {

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
