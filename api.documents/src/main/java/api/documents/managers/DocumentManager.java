package api.documents.managers;

import java.util.List;

import api.documents.beans.Document;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface DocumentManager.
 */
public interface DocumentManager {
	
	/**
	 * Search documents.
	 *
	 * @param customerAccountId the customer account id
	 * @param customerUserId the customer user id
	 * @param pendingOnly the pending only
	 * @param includeContent the include content
	 * @return the list
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public List<Document> searchDocuments(String customerAccountId, String customerUserId, boolean pendingOnly, boolean includeContent) throws ClientException, ResponseException;	
	
	/**
	 * Gets the document.
	 *
	 * @param id the id
	 * @param includeContent the include content
	 * @return the document
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public Document getDocument(int id, boolean includeContent) throws ClientException, ResponseException;	
	
	/**
	 * Acknowledge document delivery.
	 *
	 * @param id the id
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public void acknowledgeDocumentDelivery(int id) throws ClientException, ResponseException;
}
