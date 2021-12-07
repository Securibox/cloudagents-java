  /**
   * Copyright (C) 2021 Securibox
   * 
   */

package eu.securibox.cloudagents.api.documents;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.securibox.cloudagents.api.documents.beans.Synchronization;

import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.Response;
import eu.securibox.cloudagents.core.exceptions.*;
import eu.securibox.cloudagents.core.http.UriParameters;
import eu.securibox.cloudagents.core.Utils;


/**
 * Wrapper for the Synchronizations related methods.
 *
 */
public class Synchronizations {

	private static String path = "synchronizations/";

	/**
	 * Launches a new synchronizations to download documents.
	 * @param customerAccountId The customer account identifier
	 * @param customerUserId The customer user identifier
	 * @param isForced If true, sets the synchronization as forced, thus overriding the document unicity check.
	 * @return A list of synchronisations with a single item
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	 */
	public List<Synchronization> createSynchronizations(String customerAccountId, String customerUserId,
			boolean isForced) throws ClientException, ResponseException {

		Client c = ApiClient.getClient();

		SynchronizeRequest req = new SynchronizeRequest(customerAccountId, customerUserId, isForced);

		String payload = c.serialize(req);

		Response r = c.post(path, payload);
		return c.deserialize(r.getBody(), new TypeReference<List<Synchronization>>() {
		});
	}

	/**
	 * Searches synchronisations by multiple parameters
	 * @param customerAccountId The customer account identifier
	 * @param customerUserId The customer user identifier
	 * @param startDate if set, only lists synchronisation having started after this date
	 * @param endDate if set, only lists synchronisation having ended before this date
	 * @return A list of synchronisations
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	* @throws UnsupportedEncodingException
	*    		An Unsupported Encoding Exception
	 */
	public List<Synchronization> searchSynchronizations(String customerAccountId, String customerUserId, Date startDate,
			Date endDate) throws ClientException, ResponseException, UnsupportedEncodingException {

		if (Utils.nullOrEmpty(customerUserId) && Utils.nullOrEmpty(customerAccountId))
			throw new IllegalArgumentException(
					"Arguments customerAccountId and customerUserId can not be both null or empty");

		Client c = ApiClient.getClient();

		UriParameters pars = new UriParameters();
		pars.put("customerAccountId", customerAccountId);
		pars.put("customerUserId", customerUserId);
		pars.put("startDate", startDate);
		pars.put("endDate", endDate);

		Response r = c.get(path + "search?" + pars.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Synchronization>>() {
		});
	}

	/**
	 * Acknowledges a delivery of documents
	 * @param customerAccountId The customer account identifier
	 * @param documentIds The ids of all the documents retrieved during the synchronization, as listed in the synchronization report
	 * @param missingDocumentIds The ids of the documents not received
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	 */
	public void acknowledgeSynchronizationDelivery(String customerAccountId, long[] documentIds,
			long[] missingDocumentIds) throws ClientException, ResponseException {
		
		Client c = ApiClient.getClient();
		
		SynchronizationAcknowledgement ackn = new SynchronizationAcknowledgement(customerAccountId, documentIds, missingDocumentIds);
		
		String payload = c.serialize(ackn);
		
		c.put(path + customerAccountId + "/ack", payload);
	}

	private class SynchronizeRequest {
		@SuppressWarnings("unused")
		private String customerAccountId;
		@SuppressWarnings("unused")
		private String customerUserId;
		@SuppressWarnings("unused")
		private boolean isForced;

		SynchronizeRequest(String customerAccountId, String customerUserId, boolean isForced) {
			this.customerAccountId = customerAccountId;
			this.customerUserId = customerUserId;
			this.isForced = isForced;
		}
	}

	private class SynchronizationAcknowledgement {
		
		@SuppressWarnings("unused")
		private String customerAccountId;
		@SuppressWarnings("unused")
		private long[] documentIds;
		@SuppressWarnings("unused")
		private long[] missingDocumentIds;

		SynchronizationAcknowledgement(String customerAccountId, long[] documentIds, long[] missingDocumentIds) {
			this.customerAccountId = customerAccountId;
			this.documentIds = documentIds;
			this.missingDocumentIds = missingDocumentIds;
		}
	}
}
