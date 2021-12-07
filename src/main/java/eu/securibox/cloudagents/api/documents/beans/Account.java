package eu.securibox.cloudagents.api.documents.beans;


import java.util.ArrayList;
import java.util.List;

import eu.securibox.cloudagents.core.types.AccountMode;

/**
 * Object representing one agent account of the user
 */
public class Account {
	
	/** The customer account id. */
	private String customerAccountId;
	
	/** The customer user id. */
	private String customerUserId;
	
	/** The name. */
	private String name;
	
	/** The agent id. */
	private String agentId;
	
	/** The credentials. */
	private List<Credential> credentials;
	
	/** the account mode. */
	private AccountMode mode;
	
	/** Multi factor authentication data  */
	private AdditionalAuthData additionalAuthenticationData; 

	/**
	 * Initialises the class and all list attributes.
	 */
	public Account() {
		credentials = new ArrayList<Credential>();
	}
	/**
	 * Gets an account ID (either provided at creation time or automatically generated).
	 *
	 * @return the customer account id
	 */
	public String getCustomerAccountId() {
		return this.customerAccountId;
	}

	/**
	 * Sets an account ID
	 *
	 * @param customerAccountId the new customer account id
	 */
	public void setCustomerAccountId(String customerAccountId) {
		this.customerAccountId = customerAccountId;
	}

	/**
	 * Gets the customer user id.
	 *
	 * @return the customer user id
	 */
	public String getCustomerUserId() {
		return this.customerUserId;
	}

	/**
	 * Sets the customer user id.
	 *
	 * @param customerUserId the new customer user id
	 */
	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the agent id.
	 *
	 * @return the agent id
	 */
	public String getAgentId() {
		return this.agentId;
	}

	/**
	 * Sets the agent id.
	 *
	 * @param agentId the new agent id
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	
	/**
	 * Sets the credentials.
	 *
	 * @param credentials the new credentials
	 */
	public void setCredentials(List<Credential> credentials) {
		this.credentials = credentials;
	}

	/**
	 * Gets the credentials.
	 *
	 * @return the credentials
	 */
	public List<Credential> getCredentials() {
		return this.credentials;
	}
	
	/**
	 * Gets the account synchronisation mode.
	 *
	 * @return String the account synchronisation mode
	 */
	public AccountMode getMode() {
		return this.mode;
	}
	
	/**
	 * Sets the account synchronisation mode.
	 *
	 * @param mode the account synchronisation mode.
	 */
	public void setMode(AccountMode mode) {
		this.mode = mode;
	}
	
	/**
	 * Gets the additional authentication data used in multi-factor authentication scenarios.
	 *
	 * @return AdditionalAuthData the additional authentication
	 */
	public AdditionalAuthData getAdditionalAuthenticationData() {
		return this.additionalAuthenticationData;
	}
}
