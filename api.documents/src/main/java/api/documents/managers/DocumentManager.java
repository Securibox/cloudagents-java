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
	public Document getDocument(long id, boolean includeContent) throws ClientException, ResponseException;	
	
	/**
	 * Acknowledge document delivery.
	 *
	 * @param id the id
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public void acknowledgeDocumentDelivery(long id) throws ClientException, ResponseException;
}
