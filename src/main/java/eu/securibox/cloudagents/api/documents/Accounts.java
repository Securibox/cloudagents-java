  /**
   * Copyright (C) 2021 Securibox
   * 
   */

package eu.securibox.cloudagents.api.documents;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.securibox.cloudagents.api.documents.beans.Account;
import eu.securibox.cloudagents.api.documents.beans.AdditionalAuthData;
import eu.securibox.cloudagents.api.documents.beans.AdditionalAuthRequest;
import eu.securibox.cloudagents.api.documents.beans.Document;
import eu.securibox.cloudagents.api.documents.beans.Synchronization;
import eu.securibox.cloudagents.api.documents.beans.SynchronizationRequest;
import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.Response;
import eu.securibox.cloudagents.core.Utils;
import eu.securibox.cloudagents.core.exceptions.*;
import eu.securibox.cloudagents.core.http.*;

/**
 * Wrapper for the agents related methods.
 */
public class Accounts {

	private String path = "Accounts/";
	
   /**
   * Creates and optionally synchronises an account.
   * @param account The account object to be created.
   * @param synchronize Specifies if the account is to be synchronised immediately after the creation.
   * @return The created account.
   * @throws ClientException
   * 			A client exception
   * @throws ResponseException
   * 			A response exception
   */ 
	public Account createAccount(Account account, boolean synchronize) throws ClientException, ResponseException {
		
		Client c = ApiClient.getClient();
		
		CreateAccountRequest req = new CreateAccountRequest(account, synchronize);
		String payload = c.serialize(req);
		
		Response r = c.post(path, payload);
		return c.deserialize(r.getBody(), new TypeReference<Account>(){});		
	}

   /**
   * Lists all accounts.
   * @return A list of all accounts
   * @throws UnsupportedEncodingException
   * 			An Unsupported Encoding Exception
   * @throws ClientException
   * 			A client exception
   * @throws ResponseException
   * 			A response exception
   */ 
	public List<Account> listAccounts() throws UnsupportedEncodingException, ClientException, ResponseException{
		return this.listAccounts(null, null, 0, 0);
	}
   /**
   * Lists accounts filtering by the provided parameters. 
   * @param agentId filters accounts by the agent id
   * @param customerUserId filters accounts by customer user id
   * @param pageNumber the page number to be returned (starting from 0)
   * @param pageSize number of elements to be returned
   * @return A list of accounts matching the provided filters
   * @throws ClientException
   * 			A client exception
   * @throws ResponseException
   * 			A response exception
   * @throws UnsupportedEncodingException
   * 			An Unsupported Encoding Exception
   */ 
	public List<Account> listAccounts(String agentId, String customerUserId, int pageNumber, int pageSize) throws ClientException, ResponseException, UnsupportedEncodingException {
		
		Client c = ApiClient.getClient();
		
		UriParameters par = new UriParameters();
		par.put("agentId", agentId);
		par.put("customerUserId", customerUserId);
		par.put("skip", pageSize*pageNumber);
		par.put("take", pageNumber);

		Response r = c.get(path + "/search?"+ par.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Account>>(){});		
	}

	/**
	* Gets an account by its customer account identifier
	* @param customerAccountId The account identifier
	* @return The account matching the provided identifier
   * @throws ClientException
   * 			A client exception
   * @throws ResponseException
   * 			A response exception
	*/ 
	public Account getAccount(String customerAccountId) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		Response r = c.get(path + customerAccountId);
		return c.deserialize(r.getBody(), new TypeReference<Account>(){});
	}
	
	/**
	* Updates an existing account information.
	* @param account The account object with the new values
	* @return The updated account
   * @throws ClientException
   * 			A client exception
   * @throws ResponseException
   * 			A response exception
	*/
	public Account updateAccount(Account account) throws ClientException, ResponseException {
		
		Client c = ApiClient.getClient();
		
		String payload = c.serialize(account);
		
		Response r = c.put(path + account.getCustomerAccountId(), payload);
		return c.deserialize(r.getBody(), new TypeReference<Account>(){});	
	}

	/**
	* Deletes an account
	* @param customerAccountId The account identifier
   * @throws ClientException
   * 			A client exception
   * @throws ResponseException
   * 			A response exception
	*/
	public void deleteAccount(String customerAccountId) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		c.delete(path + customerAccountId);
	}

	/**
	* Lists all documents downloaded by the last account synchronisation.
	* @param customerAccountId The account identifier
	* @param pendingOnly if set to true, only lists documents that haven't been acknowledged.
	* @param includeContent specifies if the response should include the document content in base64 encoding.
	* @return A list of documents
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	* @throws UnsupportedEncodingException
	* 			An Unsupported Encoding Exception
	*/
	public List<Document> listDocumentsByAccount(String customerAccountId, boolean pendingOnly, boolean includeContent) throws ClientException, ResponseException, UnsupportedEncodingException {
		Client c = ApiClient.getClient();
		
		UriParameters par = new UriParameters();
		par.put("pendingOnly", pendingOnly);
		par.put("includeContent", includeContent);
		
		Response r = c.get(path + customerAccountId + "/documents?" + par.getParameterString() );
		return c.deserialize(r.getBody(), new TypeReference<List<Document>>(){});
	}

	/**
	* Lists all synchronisations performed by the account.
	* @param customerAccountId The account identifier
	* @param startDate filters synchronisation from this date 
	* @param endDate filters synchronisation until this date  
	* @return A list of synchronisations
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	* @throws UnsupportedEncodingException
	*    		An Unsupported Encoding Exception
	*/
	public List<Synchronization> listSynchronizationsByAccount(String customerAccountId, Date startDate, Date endDate) throws ClientException, ResponseException, UnsupportedEncodingException {
		Client c = ApiClient.getClient();
		
		UriParameters par = new UriParameters();
		par.put("startDate", startDate);
		par.put("endDate", endDate);
				
		Response r = c.get(path + customerAccountId + "/synchronizations?" + par.getParameterString() );
		return c.deserialize(r.getBody(), new TypeReference<List<Synchronization>>(){});
	}
	/**
	* Gets the last synchronisation of an account.
	* @param customerAccountId The customer account identifier for which you want to have the last synchronisation.
	* @return A synchronisation object
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	*/
	public Synchronization getLastSynchronizationOfAccount(String customerAccountId) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		Response r = c.get(path + customerAccountId + "/synchronizations/last");
		return c.deserialize(r.getBody(), new TypeReference<Synchronization>(){});
	}

	/**
	* Launches the synchronisation for a specific account.
	* @param customerAccountId The customer account identifier
	* @param isForced if set to <b>true</b>, downloads all available documents even if they have already been downloaded during previous synchronisations.
	* @return A synchronisation object
    * @throws ClientException
    * 			A client exception
    * @throws ResponseException
    * 			A response exception
	*/
	public Synchronization synchronizeAccount(String customerAccountId, boolean isForced) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		
		SynchronizationRequest synchRequest = new SynchronizationRequest(customerAccountId, isForced);
		String payload = c.serialize(synchRequest);
		Response r = c.post(path + customerAccountId + "/synchronizations", payload);
		return c.deserialize(r.getBody(), new TypeReference<Synchronization>(){});
	}
	
	/**
	 * Adds a multifactor authentication code to resume the synchronisation.
	 * @param customerAccountId The customer account identifier
	 * @param secretCode The secret code sent through another channel
	 * @return true if the code has been successfully sent
     * @throws ClientException
     * 			A client exception
     * @throws ResponseException
     * 			A response exception
	 */
	public boolean AddMultiFactorAuthenticationSecretCode(String customerAccountId, String secretCode) throws ClientException, ResponseException {
		if(Utils.nullOrEmpty(customerAccountId)) {
			throw new IllegalArgumentException("No customer account id provided.");
		}
		if(Utils.nullOrEmpty(secretCode)) {
			throw new IllegalArgumentException("No secret code provided.");
		}
		Client c = ApiClient.getClient();
		AdditionalAuthRequest request = new AdditionalAuthRequest(customerAccountId, secretCode);
		String payload = c.serialize(request);
		Response r = c.post(path + customerAccountId + "/mfa", payload);
		return r.getStatusCode() == 200;
	}
	
	/**
	 * This method allows you to know on which channel has the secret code been sent to the user when a synchronizationStateDetails reaches the AdditionalAuthenticationRequired status.
	 * @param customerAccountId The customer account identifier
	 * @return an AdditionalAuthData object
   * @throws ClientException
   * 			A client exception
   * @throws ResponseException
   * 			A response exception
	 */
	public AdditionalAuthData GetMultifactorAuthenticationData(String customerAccountId) throws ClientException, ResponseException {
		if(Utils.nullOrEmpty(customerAccountId)) {
			throw new IllegalArgumentException("No customer account id provided.");
		}
		Client c = ApiClient.getClient();
		Response r = c.get(path + customerAccountId + "/mfa");
		return c.deserialize(r.getBody(), new TypeReference<AdditionalAuthData>(){});
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
