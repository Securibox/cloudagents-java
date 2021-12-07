  /**
   * Copyright (C) 2017 Securibox
   * 
   */

package eu.securibox.cloudagents.api.banks.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
	
	/** The customer account Id defined by the client application or automatically assigned by SCA */
	private String customerAccountId;
	
	/** The customer user id. */
	private String customerUserId;

	/** The name. */
	private String name;

	/** The bank id. */
	private String bankId;

	/** The credentials. */
	private List<Credential> credentials;

	/** The mode. */
	private AccountMode mode;
	
	/** The last synchronization date. */
	private Date lastSynchDate;
	
	/** The last synchronization state. */
	private String lastSynchronizationState;
	
	/** The last synchronization identifier. */
	private String lastSynchronizationIdentifier;
	
	/**
	 * Initialises the class and all list attributes.
	 */
	public Account() {
		credentials = new ArrayList<Credential>();
	}

	/**
	 * Sets the customer account id.
	 *
	 * @param customerAccountId
	 *            the new customer account id
	 */
	public void setCustomerAccountId(String customerAccountId) {
		this.customerAccountId = customerAccountId;
	}

	/**
	 * Gets the customer account id.
	 *
	 * @return the customer account id
	 */
	public String getCustomerAccountId() {
		return this.customerAccountId;
	}

	/**
	 * Sets the customer user id.
	 *
	 * @param customerUserId
	 *            the new customer user id
	 */
	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
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
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Sets the bank id.
	 *
	 * @param bankId
	 *            the new bank id
	 */
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the bank id.
	 *
	 * @return the bank id
	 */
	public String getBankId() {
		return this.bankId;
	}

	/**
	 * Gets the credentials.
	 *
	 * The method returns the internal object, not a shallow copy. Any
	 * modifications will affect directly the credential list, therefore no
	 * setter method is necessary.
	 *
	 * @return the credentials
	 */
	public List<Credential> getCredentials() {
		return this.credentials;
	}

	/**
	 * Gets the account mode.
	 *
	 * @return the mode
	 */
	public AccountMode getMode() {
		return mode;
	}

	/**
	 * Sets the account mode.
	 *
	 * @param mode the new mode
	 */
	public void setMode(AccountMode mode) {
		this.mode = mode;
	}
	/**
	 * Gets the last synchronization date
	 *
	 * @return the last synchronization date
	 */
	public Date getLastSynchDate(){
		return this.lastSynchDate;
	}
	/**
	 * Gets the last synchronization status
	 *
	 * @return the last synchronization status
	 */
	public String getLastSynchronizationState(){
		return this.lastSynchronizationState;
	}
	/**
	 * Gets the last synchronization identifier
	 *
	 * @return the last synchronization identifier
	 */
	public String getLastSynchronizationIdentifier(){
		return this.lastSynchronizationIdentifier;
	}

}
