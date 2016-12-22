package api.documents.managers.impl;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import api.documents.beans.Account;
import api.documents.beans.Agent;
import api.documents.beans.AgentCountryCode;
import api.documents.managers.AgentManager;
import core.Client;
import core.Response;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;
import core.impl.Utils;

class Agents implements AgentManager {

	private String path = "agents/";

	public List<Agent> listAgents(String culture) throws ClientException, ResponseException {

		Client c = ApiClient.getClient();

		String url = path;
		if(!Utils.nullOrEmpty(culture)){
			UriParameters par = new UriParameters();
			par.put("culture", culture);
			url += "?" + par.getParameterString();			
		}

		Response r = c.get(url);
		return c.deserialize(r.getBody(), new TypeReference<List<Agent>>() {
		});
	}

	public List<Agent> searchAgents(AgentCountryCode countryCode, String culture, String query) throws ClientException, ResponseException {

		Client c = ApiClient.getClient();

		String url = path + "search?";
		
		UriParameters par = new UriParameters();
		par.put("countryCode", countryCode);
		par.put("culture", culture);
		par.put("q", query);
		
		Response r = c.get(url + par.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Agent>>() {
		});
	}

	public List<Account> listAccountsByAgent(String agentId, int skip, int take)
			throws ClientException, ResponseException {

		if (Utils.nullOrEmpty(agentId))
			throw new IllegalArgumentException("No agentId provided");

		Client c = ApiClient.getClient();

		String url = path + agentId + "/accounts?";
		
		UriParameters par = new UriParameters();
		par.put("skip", skip);
		par.put("take", take);

		Response r = c.get(url + par.getParameterString());
		return c.deserialize(r.getBody(), new TypeReference<List<Account>>() {
		});
	}
}
