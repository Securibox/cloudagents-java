  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

/**
 * A class representing an synchronisation launch request.
 */
public class SynchronizationRequest {
	/** The customer account identifier.*/
	private String customerAccountId;
	/** The customer user identifier.*/
	private String customerUserId;
	 /** A value indicating whether this synchronisation is forced.*/
	private boolean isForced;
	
	public SynchronizationRequest(String customerAccountId, String customerUserId, boolean isForced) {
		this.customerAccountId = customerAccountId;
		this.customerUserId = customerUserId;
		this.isForced = isForced;
	}
	
	public SynchronizationRequest(String customerAccountId, boolean isForced) {
		this.customerAccountId = customerAccountId;
		this.isForced = isForced;
	}
	/**
	 * Sets the customer account ID.
	 *
	 * @param customerAccountId the customer account ID.
	 */
	public void setCustomerAccountId(String customerAccountId) {
		this.customerAccountId = customerAccountId;
	}
	/**
	 * Gets the customer account ID.
	 *
	 * @return the customer account ID.
	 */
	public String getCustomerAccountId() {
		return this.customerAccountId;
	}
	/**
	 * Sets the customer user ID.
	 *
	 * @param customerUserId the customer user ID.
	 */
	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
	}
	/**
	 * Gets the customer user ID.
	 *
	 * @return the customer user ID.
	 */
	public String getCustomerUserId() {
		return this.customerUserId;
	}
	 /** 
	 * Sets the value of isForced
	 *
	 * @param isForced true if the synchronisation is forced, false otherwise.
	 */
	public void setIsForced(boolean isForced) {
		this.isForced = isForced;
	}
	/**
	 * Gets the value of isForced
	 *
	 * @return true if the synchronisation is forced, false otherwise.
	 */
	public boolean getIsForced() {
		return this.isForced;
	}
	
}
