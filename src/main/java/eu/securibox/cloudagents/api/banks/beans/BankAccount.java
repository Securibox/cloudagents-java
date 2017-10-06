package eu.securibox.cloudagents.api.banks.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Class BankAccount.
 */
public class BankAccount {

	/** The bank account id. */
	private String id;

	/** The customer account id. */
	private String customerAccountId;

	/** The bank account iban. */
	private String IBAN;

	/** The bank account number. */
	private String number;

	/** The bank account name. */
	private String name;

	/** The bank account custom name. */
	private String customName;

	/** The bank account currency. */
	private String currency;

	/** Date specifying the date from which data has been downloaded. */
	private Date transactionsFrom;

	/** The bank account balance. */
	private Balance balance;

	/** The state. */
	private AccountState state;

	/** The type. */
	private BankAccountType type;
	
	/** The cards. */
	private List<Card> cards;

	/** The bank account transactions. */
	private List<Transaction> transactions;

	/**
	 * Initializes the class and all list attributes.
	 */
	public BankAccount() {
		this.transactions = new ArrayList<Transaction>();
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return this.id;
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
	 * Sets the bank account iban.
	 *
	 * @param IBAN
	 *            the new iban
	 */
	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}

	/**
	 * Gets the bank account iban.
	 *
	 * @return the iban
	 */
	public String getIBAN() {
		return this.IBAN;
	}

	/**
	 * Sets the bank account number.
	 *
	 * @param number the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Gets the bank account number.
	 *
	 * @return the account number
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * Sets the bank account name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the bank account name.
	 *
	 * @return the bank account name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the bank account custom name.
	 *
	 * @param customName
	 *            the new bank account custom name
	 */
	public void setCustomName(String customName) {
		this.customName = customName;
	}

	/**
	 * Gets the bank account custom name.
	 *
	 * @return the bank account custom name
	 */
	public String getCustomName() {
		return this.customName;
	}

	/**
	 * Sets the bank account currency.
	 *
	 * @param currency
	 *            the new bank account currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the bank account currency.
	 *
	 * @return the bank account currency
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Sets the date that the transactions have been collected from.
	 *
	 * @param transactionsFromDate
	 *            the date that the transactions have been collected from.
	 */
	public void setTransactionsFrom(Date transactionsFromDate) {
		this.transactionsFrom = transactionsFromDate;
	}

	/**
	 * Gets the date that the transactions have been collected from.
	 *
	 * @return the date that the transactions have been collected from.
	 */
	public Date getTransactionsFrom() {
		return this.transactionsFrom;
	}

	/**
	 * Sets the bank account balance.
	 *
	 * @param balance
	 *            the bank account balance.
	 */
	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	/**
	 * Gets the bank account balance.
	 *
	 * @return the bank account balance.
	 */
	public Balance getBalance() {
		return this.balance;
	}

	/**
	 * Gets the transactions.
	 * 
	 * The method returns the internal object, not a shallow copy. Any
	 * modifications will affect directly the transaction list, therefore no
	 * setter method is necessary.
	 *
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public AccountState getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state
	 *            the new state
	 */
	public void setState(AccountState state) {
		this.state = state;
	}

	/**
	 * Gets the cards.
	 *
	 * @return the cards
	 */
	public List<Card> getCards() {
		return cards;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public BankAccountType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(BankAccountType type) {
		this.type = type;
	}

}