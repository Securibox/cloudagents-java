package api.documents.managers.impl;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import api.documents.beans.Account;
import api.documents.beans.Document;
import api.documents.beans.Synchronization;
import api.documents.managers.AccountManager;
import core.Client;
import core.Response;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;

public class Accounts implements AccountManager {

	private String path = "Accounts/";
	
	public Account createAccount(Account account, boolean synchronize) throws ClientException, ResponseException {
		
		Client c = ApiClient.getClient();
		
		CreateAccountRequest req = new CreateAccountRequest(account, synchronize);
		String payload = c.serialize(req);
		
		Response r = c.post(path, payload);
		return c.deserialize(r.getBody(), new TypeReference<Account>(){});		
	}

	public List<Account> listAccounts(String agentId, String customerUserId, int skip, int take) throws ClientException, ResponseException {
		
		Client c = ApiClient.getClient();
		
		UriParameters par = new UriParameters();
		par.put("agentId", agentId);
		par.put("customerUserId", customerUserId);
		par.put("skip", skip);
		par.put("take", take);

		Response r = c.get(path + "?"+ par.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Account>>(){});		
	}

	public Account getAccount(String customerAccountId) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		Response r = c.get(path + customerAccountId);
		return c.deserialize(r.getBody(), new TypeReference<Account>(){});
	}

	public Account updateAccount(Account account) throws ClientException, ResponseException {
		
		Client c = ApiClient.getClient();
		
		String payload = c.serialize(account);
		
		Response r = c.put(path + account.getCustomerAccountId(), payload);
		return c.deserialize(r.getBody(), new TypeReference<Account>(){});	
	}

	public void deleteAccount(String customerAccountId) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		c.delete(path + customerAccountId);
	}

	public List<Document> listDocumentsByAccount(String customerAccountId, boolean pendingOnly,
			boolean includeContent) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		UriParameters par = new UriParameters();
		par.put("pendingOnly", pendingOnly);
		par.put("includeContent", includeContent);
		
		Response r = c.get(path + customerAccountId + "/documents?" + par.getParameterString() );
		return c.deserialize(r.getBody(), new TypeReference<List<Document>>(){});
	}

	public List<Synchronization> listSynchronizationsByAccount(String customerAccountId, Date startDate, Date endDate) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		UriParameters par = new UriParameters();
		par.put("startDate", startDate);
		par.put("endDate", endDate);
				
		Response r = c.get(path + customerAccountId + "/synchronizations?" + par.getParameterString() );
		return c.deserialize(r.getBody(), new TypeReference<List<Synchronization>>(){});
	}

	public Synchronization getLastSynchronizationOfAccount(String customerAccountId) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		Response r = c.get(path + customerAccountId + "/synchronizations/last");
		return c.deserialize(r.getBody(), new TypeReference<Synchronization>(){});
	}

	public Synchronization synchronizeAccount(String customerAccountId, boolean isForced) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	private class CreateAccountRequest{
		
		@SuppressWarnings("unused")
		private Account account;
		@SuppressWarnings("unused")
		private boolean synchronize;		
		
		CreateAccountRequest(Account account, boolean synchronize){
			this.account = account;
			this.synchronize = synchronize;
		}
	}
}
