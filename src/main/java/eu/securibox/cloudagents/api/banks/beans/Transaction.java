package eu.securibox.cloudagents.api.banks.beans;

import java.util.Date;

/**
 * The Class Transaction.
 */
public class Transaction {

	/** The transaction date. */
	private Date transactionDate;

	/** The value date. */
	private Date valueDate;

	/** The label. */
	private String label;

	/** The amount. */
	private float amount;

	/** The currency. */
	private String currency;

	/** The type. */
	private TransactionType type;
	
	/** The intraday. */
	private boolean intradays;

	/**
	 * Sets the transaction date.
	 *
	 * @param transactionDate
	 *            the new transaction date
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * Gets the transaction date.
	 *
	 * @return the transaction date
	 */
	public Date getTransactionDate() {
		return this.transactionDate;
	}

	/**
	 * Sets the value date.
	 *
	 * @param valueDate
	 *            the new value date
	 */
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	/**
	 * Gets the value date.
	 *
	 * @return the value date
	 */
	public Date getValueDate() {
		return this.valueDate;
	}

	/**
	 * Sets the transaction label.
	 *
	 * @param label
	 *            the new transaction label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Gets the transaction label.
	 *
	 * @return the transaction label
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Sets the transaction amount.
	 *
	 * @param amount
	 *            the new transaction amount
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/**
	 * Gets the transaction amount.
	 *
	 * @return the transaction amount
	 */
	public float getAmount() {
		return this.amount;
	}

	/**
	 * Sets the transaction currency.
	 *
	 * @param currency
	 *            the new transaction currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the transaction currency.
	 *
	 * @return the transaction currency
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public TransactionType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(TransactionType type) {
		this.type = type;
	}

	/**
	 * Checks if is intraday.
	 *
	 * @return true, if is intraday
	 */
	public boolean isIntradays() {
		return intradays;
	}

	/**
	 * Sets the intraday.
	 *
	 * @param intraday the new intraday
	 */
	public void setIntradays(boolean intraday) {
		this.intradays = intraday;
	}
}