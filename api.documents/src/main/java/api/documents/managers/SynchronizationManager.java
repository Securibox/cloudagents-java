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

import java.util.Date;
import java.util.List;

import api.documents.beans.Synchronization;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface SynchronizationManager.
 */
public interface SynchronizationManager {
	
	/**
	 * Creates the synchronizations.
	 *
	 * @param customerAccountId the customer account id
	 * @param customerUserId the customer user id
	 * @param isForced the is forced
	 * @return the list
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public List<Synchronization> createSynchronizations(String customerAccountId, String customerUserId, boolean isForced) throws ClientException, ResponseException;
	
	/**
	 * Search synchronizations.
	 *
	 * @param customerAccountId the customer account id
	 * @param customerUserId the customer user id
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the list
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public List<Synchronization> searchSynchronizations(String customerAccountId, String customerUserId, Date startDate, Date endDate) throws ClientException, ResponseException;
	
	/**
	 * Acknowledge synchronization delivery.
	 *
	 * @param customerAccountId the customer account id
	 * @param documentIds the document ids
	 * @param missingDocumentIds the missing document ids
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public void acknowledgeSynchronizationDelivery(String customerAccountId, long[] documentIds, long[] missingDocumentIds) throws ClientException, ResponseException;
}
