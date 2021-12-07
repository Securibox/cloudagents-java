  /**
   * Copyright (C) 2021 Securibox
   */

package eu.securibox.cloudagents.api.documents;

import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.SecurityConfiguration;
import eu.securibox.cloudagents.core.Utils;
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
	 * @param configuration the configuration
	 */
	public static void ConfigureClient(SecurityConfiguration configuration) {
		ApiClient.ConfigureClient(null, configuration);
	}
	
	/**
	 * Configure the client programmatically.
	 *
	 * @param baseUrl the base url
	 * @param configuration the configuration
	 */
	public static void ConfigureClient(String baseUrl, SecurityConfiguration configuration) {
		if(Utils.nullOrEmpty(baseUrl)) {
			baseUrl = "https://sca-multitenant.securibox.eu/api/v1/";
		}
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
	 * Gets the synchronisation manager.
	 *
	 * @return the synchronisation manager
	 */
	public static Synchronizations getSynchronizationManager(){
		return new Synchronizations();
	}
}
