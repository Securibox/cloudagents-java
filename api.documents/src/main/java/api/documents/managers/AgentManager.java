  /**
   * Copyright (C) 2016 Securibox
   * 
   * This program is free software: you can redistribute it and/or modify 
   * it under the terms of the GNU General Public License as published by 
   * the Free Software Foundation, either version 3 of the License, or 
   * (at your option) any later version.
   * 
   * This program is distributed in the hope that it will be useful, 
   * but WITHOUT ANY WARRANTY; without even the implied warranty of 
   * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
   * GNU General Public License for more details.
   * 
   * You should have received a copy of the GNU General Public License 
   * along with this program.  If not, see <http://www.gnu.org/licenses/>.
   */

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
