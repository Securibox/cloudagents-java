package eu.securibox.cloudagents.api.banks;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.securibox.cloudagents.api.banks.beans.BankAccount;
import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.Response;
import eu.securibox.cloudagents.core.exceptions.ClientException;
import eu.securibox.cloudagents.core.exceptions.ResponseException;


public class BankAccounts {
	
	private String path = "bankaccounts/";

	public List<BankAccount> ListBankAccountsByAccount(String customerAccountId)
			throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		Response r = c.get("accounts/" + customerAccountId + "/bankaccounts");
		return c.deserialize(r.getBody(), new TypeReference<List<BankAccount>>(){});
	}

	public BankAccount GetBankAccount(String id) throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		Response r = c.get(path + id);
		return c.deserialize(r.getBody(), new TypeReference<BankAccount>(){});
	}

}
