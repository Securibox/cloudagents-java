package eu.securibox.cloudagents.api.banks;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.securibox.cloudagents.api.banks.beans.Bank;
import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.Response;
import eu.securibox.cloudagents.core.exceptions.ClientException;
import eu.securibox.cloudagents.core.exceptions.ResponseException;


public class Banks {

	private String path = "Banks/";
	
	public List<Bank> ListBanks() throws ClientException, ResponseException {
		Client c = ApiClient.getClient();
		Response r = c.get(path);
		return c.deserialize(r.getBody(), new TypeReference<List<Bank>>(){});
	}

}
