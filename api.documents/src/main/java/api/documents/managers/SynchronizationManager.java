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
	public void acknowledgeSynchronizationDelivery(String customerAccountId, int[] documentIds, int[] missingDocumentIds) throws ClientException, ResponseException;
}
