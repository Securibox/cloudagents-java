package api.documents.managers;

import java.util.List;

import api.documents.beans.Account;
import api.documents.beans.Agent;
import api.documents.beans.AgentCountryCode;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface AgentManager.
 */
public interface AgentManager {
	
	/**
	 * List agents.
	 *
	 * @param culture the culture
	 * @return the list
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public List<Agent> listAgents(String culture) throws ClientException, ResponseException;

	/**
	 * Search agents.
	 *
	 * @param countryCode the country code
	 * @param culture the culture
	 * @param query the query
	 * @return the list
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public List<Agent> searchAgents(AgentCountryCode countryCode, String culture, String query) throws ClientException, ResponseException;

	/**
	 * List accounts by agent.
	 *
	 * @param agentId the agent id
	 * @param skip the skip
	 * @param take the take
	 * @return the list
	 * @throws ClientException the client exception
	 * @throws ResponseException the response exception
	 */
	public List<Account> listAccountsByAgent(String agentId, int skip, int take) throws ClientException, ResponseException;
}
