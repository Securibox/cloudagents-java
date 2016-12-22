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

	public Document getDocument(int id, boolean includeContent) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		UriParameters pars = new UriParameters();
		pars.put("includeContent", includeContent);
		
		Response r = c.get(path + Integer.toString(id)  + "?" + pars.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<Document>(){});
	}

	public void acknowledgeDocumentDelivery(int id) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		String payload = c.serialize(id);
		c.put(path + Integer.toString(id)  + "/ack?", payload );
	}

}
