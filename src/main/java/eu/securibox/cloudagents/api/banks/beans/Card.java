package eu.securibox.cloudagents.api.banks.beans;

import java.util.Date;
import java.util.List;

/**
 * The Class Card.
 */
public class Card {

	/**
	 * Instantiates a new card.
	 */
	public Card() {
	}

	/** The brand. */
	private String brand;

	/** The bank account number. */
	private String number;

	/** The bank account name. */
	private String name;

	/** The bank account currency. */
	private String currency;

	/** Date specifying the date from which data has been downloaded. */
	private Date transactionsFrom;

	/** The previous balances. */
	private List<Balance> Balances;

	/** The bank account transactions. */
	private List<Transaction> transactions;

	/** The state. */
	private AccountState state;

	/**
	 * Sets the card number.
	 *
	 * @param number
	 *            the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Sets the card number.
	 * 
	 * @return the card number
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * Sets the card name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the card name.
	 *
	 * @return the card name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the card currency.
	 *
	 * @param currency
	 *            the new card currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the card currency.
	 *
	 * @return the card currency
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
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand
	 *            the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the balances.
	 *
	 * @return the balances
	 */
	public List<Balance> getBalances() {
		return Balances;
	}

	/**
	 * Sets the balances.
	 *
	 * @param previousBalances the new balances
	 */
	public void setBalances(List<Balance> previousBalances) {
		this.Balances = previousBalances;
	}
}
