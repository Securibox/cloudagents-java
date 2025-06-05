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
import eu.securibox.cloudagents.core.http.UriParameters;

import eu.securibox.cloudagents.api.documents.beans.Document;

/**
 * Wrapper for the Documents related methods.
 *
 */
public class Documents {
	
	private static String path = "documents/";
	
	/**
	* Searches the documents.
	* @param customerAccountId Filter documents by the provided customer account identifier
	* @param customerUserId Filter documents by the provided customer user identifier
	* @param pendingOnly if set to true, only lists documents that haven't been acknowledged.
	* @param includeContent specifies if the response should include the document content in base64 encoding.
	* @return A list of documents
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	* @throws UnsupportedEncodingException
	*    		An Unsupported Encoding Exception
	*/
	public List<Document> searchDocuments(String customerAccountId, String customerUserId, boolean pendingOnly,
			boolean includeContent) throws ClientException, ResponseException, UnsupportedEncodingException {
		Client c = ApiClient.getClient();
		
		UriParameters pars = new UriParameters();
		pars.put("customerAccountId", customerAccountId);
		pars.put("customerUserId", customerUserId);
		pars.put("pendingOnly", pendingOnly);
		pars.put("includeContent", includeContent);
		
		Response r = c.get(path + "search?" + pars.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Document>>(){});
	}

	/**
    * Gets a specific document.
    * @param id The document identifier
    * @param includeContent specifies if the response should include the document content in base64 encoding.
    * @return A document object
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	* @throws UnsupportedEncodingException
	*    		An Unsupported Encoding Exception
	 */
	public Document getDocument(long id, boolean includeContent) throws ClientException, ResponseException, UnsupportedEncodingException {
		Client c = ApiClient.getClient();
		
		UriParameters pars = new UriParameters();
		pars.put("includeContent", includeContent);
		
		Response r = c.get(path + Long.toString(id)  + "?" + pars.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<Document>(){});
	}

	/**
	* Acknowledges the document delivery.
	* @param id The document identifier
	* @param failed  True if delivery failed.
	* @param refused True if delivery was explicitly refused.
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
    * @throws UnsupportedEncodingException
	*    		An Unsupported Encoding Exception
	 */
	public void acknowledgeDocumentDelivery(long id, boolean failed, boolean refused) throws ClientException, ResponseException, UnsupportedEncodingException {
		Client c = ApiClient.getClient();
		if (refused && failed) {
			throw new IllegalArgumentException("Cannot acknowledge a document as both failed and refused at the same time.");	
		}

		UriParameters pars = new UriParameters();
		pars.put("failed", failed);
		pars.put("refused", refused);
		
		c.put(path + Long.toString(id)  + "/ack?" + pars.getParameterString());
	}

}
