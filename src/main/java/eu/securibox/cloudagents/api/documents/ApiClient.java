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

package eu.securibox.cloudagents.api.documents;

import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.SecurityConfiguration;
import eu.securibox.cloudagents.core.exceptions.SecurityConfigurationException;
import eu.securibox.cloudagents.core.http.HttpClient;

// TODO: Auto-generated Javadoc
/**
 * This class handles the connection to SecuriboxCloudAgents API.
 */
public class ApiClient {

	/** The client. */
	private static Client client;

	/**
	 * Configure the client using a configuration file.
	 *
	 * @param configFile the config file
	 * @throws SecurityConfigurationException the security configuration exception
	 */
	public static void ConfigureClient(String configFile) throws SecurityConfigurationException {
		ApiClient.client = HttpClient.FromConfigFile(configFile);
	}

	/**
	 * Configure the client programmatically.
	 *
	 * @param baseUrl the base url
	 * @param configuration the configuration
	 */
	public static void ConfigureClient(String baseUrl, SecurityConfiguration configuration) {
		ApiClient.client = new HttpClient(baseUrl, configuration);
	}
	
	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	static Client getClient() {
		if(ApiClient.client== null){
			throw new NullPointerException("The client has not be configured yet. Call ConfigureClient before starting any API call");
		}
		return ApiClient.client;
	}
	
	/**
	 * Gets the agent manager.
	 *
	 * @return the agent manager
	 */
	public static Agents getAgentManager(){
		return new Agents();	
	}
	
	/**
	 * Gets the account manager.
	 *
	 * @return the account manager
	 */
	public static Accounts getAccountManager(){
		return new Accounts();
	}

	/**
	 * Gets the category manager.
	 *
	 * @return the category manager
	 */
	public static Categories getCategoryManager() {
		return new Categories();
	}
	
	/**
	 * Gets the document manager.
	 *
	 * @return the document manager
	 */
	public static Documents getDocumentManager(){
		return new Documents();
	}
	
	/**
	 * Gets the synchronization manager.
	 *
	 * @return the synchronization manager
	 */
	public static Synchronizations getSynchronizationManager(){
		return new Synchronizations();
	}
}
