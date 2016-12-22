package api.documents.managers.impl;

import api.documents.managers.AccountManager;
import api.documents.managers.AgentManager;
import api.documents.managers.CategoryManager;
import api.documents.managers.DocumentManager;
import api.documents.managers.SynchronizationManager;
import core.Client;
import core.SecurityConfiguration;
import core.exceptions.SecurityConfigurationException;
import core.impl.HttpClient;

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
	public static AgentManager getAgentManager(){
		return new Agents();	
	}
	
	/**
	 * Gets the account manager.
	 *
	 * @return the account manager
	 */
	public static AccountManager getAccountManager(){
		return new Accounts();
	}

	/**
	 * Gets the category manager.
	 *
	 * @return the category manager
	 */
	public static CategoryManager getCategoryManager() {
		return new Categories();
	}
	
	/**
	 * Gets the document manager.
	 *
	 * @return the document manager
	 */
	public static DocumentManager getDocumentManager(){
		return new Documents();
	}
	
	/**
	 * Gets the synchronization manager.
	 *
	 * @return the synchronization manager
	 */
	public static SynchronizationManager getSynchronizationManager(){
		return new Synchronizations();
	}
}
