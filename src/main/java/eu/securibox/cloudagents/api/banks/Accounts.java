package eu.securibox.cloudagents.api.banks;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.Response;
import eu.securibox.cloudagents.core.exceptions.*;
import eu.securibox.cloudagents.core.http.UriParameters;

import eu.securibox.cloudagents.api.banks.beans.Account;
import eu.securibox.cloudagents.api.banks.beans.Synchronization;


public class Accounts {

	private String path = "Accounts/";

	public Account createAccount(Account account, boolean synchronize) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		CreateAccountRequest req = new CreateAccountRequest(account, synchronize);
		String payload = c.serialize(req);
		
		Response r = c.post(path, payload);
		return c.deserialize(r.getBody(), new TypeReference<Account>(){});	
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

	public List<Account> listAccounts(int skip, int take) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		UriParameters par = new UriParameters();
		par.put("skip", skip);
		par.put("take", take);
	
		Response r = c.get(path + "?"+ par.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Account>>(){});	
	}

	public List<Account> listAccountsByCustomerUserId(String customerUserId, int skip, int take) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		UriParameters par = new UriParameters();
		par.put("customerUserId", customerUserId);
		par.put("skip", skip);
		par.put("take", take);
	
		Response r = c.get(path + "?"+ par.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Account>>(){});	
	}

	public Synchronization synchronizeAccount(String customerAccountId, boolean isForced)
			throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		String payload = c.serialize(isForced);
		
		Response r = c.post(path + "/"+ customerAccountId + "/synchronizations", payload);
		return c.deserialize(r.getBody(), new TypeReference<Synchronization>(){});	
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
