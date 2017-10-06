package eu.securibox.cloudagents.api.banks.beans;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Class Synchronization.
 */
public class Synchronization {
	
	/** The customer account id. */
	private String customerAccountId;
	
	/** The customer user id. */
	private String customerUserId;
	
	/** The state. */
	private SynchronizationState state;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The delivery date. */
	private Date deliveryDate;
	
	/** The bank accounts. */
	private List<BankAccount> bankAccounts;

	
	/** The identifier. */
	private String identifier;
	
	/**
	 * Initializes the class and all list attributes.
	 */
	public Synchronization(){
		this.bankAccounts = new ArrayList<BankAccount>();
	}
	
	/**
	 * Sets the customer account id.
	 *
	 * @param customerAccountId the new customer account id
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
	 * @param customerUserId the new customer user id
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
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(SynchronizationState state) {
		this.state = state;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public SynchronizationState getState() {
		return this.state;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Sets the delivery date.
	 *
	 * @param deliveryDate the new delivery date
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * Gets the delivery date.
	 *
	 * @return the delivery date
	 */
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	/**
	 * Gets the bank accounts.
	 * 
	 * The method returns the internal object, not a shallow copy. Any modifications will affect directly the bankAccount list, therefore no
	 * setter method is necessary.
	 *
	 * @return the bank accounts
	 */
	public List<BankAccount> getBankAccounts() {
		return this.bankAccounts;
	}

	/**
	 * Gets the identifier.
	 *
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Sets the identifier.
	 *
	 * @param identifier the new identifier
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}