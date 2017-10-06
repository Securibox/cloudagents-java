package eu.securibox.cloudagents.api.banks;

import eu.securibox.cloudagents.core.Client;
import eu.securibox.cloudagents.core.SecurityConfiguration;
import eu.securibox.cloudagents.core.http.HttpClient;
import eu.securibox.cloudagents.core.exceptions.SecurityConfigurationException;


/**
 * This class handles the connection to SecuriboxCloudAgents API.
 */
public class ApiClient {

	/** The client. */
	private static Client client;

	/**
	 * Configure the client using a configuration file.
	 *
	 * @param configFile the configuration file
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
	 * Gets the bank manager.
	 *
	 * @return the bank manager
	 */
	public static Banks getBankManager(){
		return new Banks();	
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
	 * Gets the account manager.
	 *
	 * @return the account manager
	 */
	public static BankAccounts getBankAccountManager(){
		return new BankAccounts();
	}	
	

}