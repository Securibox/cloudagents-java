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

package api.documents.managers.impl;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import api.documents.beans.Document;
import api.documents.managers.DocumentManager;
import core.Client;
import core.Response;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;

public class Documents implements DocumentManager {
	
	private static String path = "documents/";
	
	public List<Document> searchDocuments(String customerAccountId, String customerUserId, boolean pendingOnly,
			boolean includeContent) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		UriParameters pars = new UriParameters();
		pars.put("customerAccountId", customerAccountId);
		pars.put("customerUserId", customerUserId);
		pars.put("pendingOnly", pendingOnly);
		pars.put("includeContent", includeContent);
		
		Response r = c.get(path + "search?" + pars.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Document>>(){});
	}

	public Document getDocument(long id, boolean includeContent) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		UriParameters pars = new UriParameters();
		pars.put("includeContent", includeContent);
		
		Response r = c.get(path + Long.toString(id)  + "?" + pars.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<Document>(){});
	}

	public void acknowledgeDocumentDelivery(long id) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		String payload = c.serialize(id);
		c.put(path + Long.toString(id)  + "/ack?", payload );
	}

}
