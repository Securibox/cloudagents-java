package api.documents.managers.impl;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import api.documents.beans.Synchronization;
import api.documents.managers.SynchronizationManager;
import core.Client;
import core.Response;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;
import core.impl.Utils;

public class Synchronizations implements SynchronizationManager {

	private static String path = "synchronizations/";

	public List<Synchronization> createSynchronizations(String customerAccountId, String customerUserId,
			boolean isForced) throws ClientException, ResponseException {

		Client c = ApiClient.getClient();

		SynchronizeRequest req = new SynchronizeRequest(customerAccountId, customerUserId, isForced);

		String payload = c.serialize(req);

		Response r = c.post(path, payload);
		return c.deserialize(r.getBody(), new TypeReference<List<Synchronization>>() {
		});
	}

	public List<Synchronization> searchSynchronizations(String customerAccountId, String customerUserId, Date startDate,
			Date endDate) throws ClientException, ResponseException {

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

	public void acknowledgeSynchronizationDelivery(String customerAccountId, int[] documentIds,
			int[] missingDocumentIds) throws ClientException, ResponseException {
		
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
		private int[] documentIds;
		@SuppressWarnings("unused")
		private int[] missingDocumentIds;

		SynchronizationAcknowledgement(String customerAccountId, int[] documentIds, int[] missingDocumentIds) {
			this.customerAccountId = customerAccountId;
			this.documentIds = documentIds;
			this.missingDocumentIds = missingDocumentIds;
		}
	}
}
