  /**
   * Copyright (C) 2021 Securibox
   * 
   */

package eu.securibox.cloudagents.api.documents;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.Response;
import eu.securibox.cloudagents.core.exceptions.*;
import eu.securibox.cloudagents.core.http.*;
import eu.securibox.cloudagents.core.types.CountryCode;
import eu.securibox.cloudagents.core.Utils;

import eu.securibox.cloudagents.api.documents.beans.Account;
import eu.securibox.cloudagents.api.documents.beans.Agent;



public class Agents {

	private String path = "agents/";
	/**
	   * Lists agents
	   * @return A list of agents
	   * @throws ClientException
	   * 			A client exception
	   * @throws ResponseException
	   * 			A response exception
	   * @throws UnsupportedEncodingException
	   * 			An Unsupported Encoding Exception
	   */	
	public List<Agent> listAgents() throws ClientException, ResponseException, UnsupportedEncodingException {
		return this.listAgents(null, false, false);
	}
	/**
	   * Lists agents
	   * @param culture The culture of the returned information
	   * @return A list of agents
	   * @throws ClientException
	   * 			A client exception
	   * @throws ResponseException
	   * 			A response exception
	   * @throws UnsupportedEncodingException
	   * 			An Unsupported Encoding Exception
	   */	
	public List<Agent> listAgents(String culture) throws ClientException, ResponseException, UnsupportedEncodingException {
		return this.listAgents(culture, false, false);
	}
	
	/**
	   * Lists agents
	   * @param culture The culture of the returned information
	   * @param includeLogo Specifies if the response should include the agent's logo encoded in base 64.
	   * @return A list of agents
	   * @throws ClientException
	   * 			A client exception
	   * @throws ResponseException
	   * 			A response exception
	   * @throws UnsupportedEncodingException
	   * 			An Unsupported Encoding Exception
	   */	
	public List<Agent> listAgents(String culture, boolean includeLogo) throws ClientException, ResponseException, UnsupportedEncodingException {
		return this.listAgents(culture, includeLogo, false);
	}

	/**
	   * Lists agents
	   * @param culture The culture of the returned information
	   * @param includeLogo Specifies if the response should include the agent's logo encoded in base 64.
	   * @param includeDisabledAgents Specifies if the response should include the agents that are disabled.
	   * @return A list of agents
	   * @throws ClientException
	   * 			A client exception
	   * @throws ResponseException
	   * 			A response exception
	   * @throws UnsupportedEncodingException
	   * 			An Unsupported Encoding Exception
	   */
	public List<Agent> listAgents(String culture, boolean includeLogo, boolean includeDisabledAgents) throws ClientException, ResponseException, UnsupportedEncodingException {

		Client c = ApiClient.getClient();

		String url = path;
		UriParameters parameters = new UriParameters();
		parameters.put("culture", culture);
		parameters.put("includeLogo", includeLogo);
		parameters.put("includeDisabledAgents", includeDisabledAgents);				
		if(parameters.size() > 0) {
			url += "?" + parameters.getParameterString();
		}

		Response r = c.get(url);
		return c.deserialize(r.getBody(), new TypeReference<List<Agent>>() {
		});
	}

	 /**
	   * Filters agents within all available agents
	   * @param countryCode The desired agents country
	   * @param culture The culture of the returned information
	   * @param includeLogo Specifies if the response should include the agent's logo encoded in base 64.
	   * @param query The query string that will filter agents starting with the defined prefix
	   * @param includeDisabledAgents Specifies if the response should include the agents that are disabled.
	   * @return A list of agents
	   * @throws ClientException
	   * 			A client exception
	   * @throws ResponseException
	   * 			A response exception
	   * @throws UnsupportedEncodingException
	   * 			An Unsupported Encoding Exception
	   */ 
	public List<Agent> searchAgents(CountryCode countryCode, String culture, boolean includeLogo, String query, boolean includeDisabledAgents) throws ClientException, ResponseException, UnsupportedEncodingException {

		Client c = ApiClient.getClient();

		String url = path + "search?";
		
		UriParameters par = new UriParameters();
		par.put("countryCode", countryCode);
		par.put("culture", culture);
		par.put("includeLogo", includeLogo);
		par.put("q", query);
		par.put("includeDisabledAgents", includeDisabledAgents);
		
		String url1 = url + par.getParameterString();
		
		Response r = c.get(url1);
		return c.deserialize(r.getBody(), new TypeReference<List<Agent>>() {
		});
	}

	 /**
	   * Gets an agent by its identifier.
	   * @param agentId String The agent identifier
	   * @param skip Number of entries to skip for pagination purposes (optional)
	   * @param take Number of entries to take for pagination purposes (optional)
	   * @return A list of accounts for the provided agent identifier
	   * @throws ClientException
	   * 			A client exception
	   * @throws ResponseException
	   * 			A response exception
	   * @throws UnsupportedEncodingException
	   * 			An Unsupported Encoding Exception
	   */ 
	public List<Account> listAccountsByAgent(String agentId, int skip, int take)
			throws ClientException, ResponseException, UnsupportedEncodingException {

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
	
	 /**
	   * Gets an agent by its identifier.
	   * @param agentId String The agent identifier
	   * @return The agent
	   * @throws ClientException
	   * 			A client exception
	   * @throws ResponseException
	   * 			A response exception
	   */ 
	public Agent getAgentByIdentifier(String agentId) throws ClientException, ResponseException {
		if(Utils.nullOrEmpty(agentId)) {
			throw new IllegalArgumentException("No agentId provided");
		}
		
		Client c = ApiClient.getClient();
		String url = path + agentId;
		try {
			Response r = c.get(url);
			return c.deserialize(r.getBody(), new TypeReference<Agent>() {
			});
		}
		catch(ResponseException ex) {
			return null;
		}
	}
}
