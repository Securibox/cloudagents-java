package eu.securibox.cloudagents.api.banks.beans;

import java.util.Date;
/**
 * The Class Balance.
 */
public class Balance {
	
	/** The available amount. */
	private float available;
	
	/** The current amount. */
	private float current;
	
	/** The balance date. */
	private Date balanceDate;
	
	/** The spent amount. */
	private float spent;
	
	/** The spent amount limit. */
	private float spentLimit;

	/**
	 * Sets the available amount.
	 *
	 * @param available the new available amount
	 */
	public void setAvailable(float available) {
		this.available = available;
	}

	/**
	 * Gets the available amount.
	 *
	 * @return the available amount
	 */
	public float getAvailable() {
		return this.available;
	}

	/**
	 * Sets the current amount.
	 *
	 * @param current the new current amount
	 */
	public void setCurrent(float current) {
		this.current = current;
	}

	/**
	 * Gets the current amount.
	 *
	 * @return the current amount
	 */
	public float getCurrent() {
		return this.current;
	}

	/**
	 * Sets the balance date.
	 *
	 * @param balanceDate the new balance date
	 */
	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	/**
	 * Gets the balance date.
	 *
	 * @return the balance date
	 */
	public Date getBalanceDate() {
		return this.balanceDate;
	}

	/**
	 * Sets the spent amount.
	 *
	 * @param spent the new spent amount
	 */
	public void setSpent(float spent) {
		this.spent = spent;
	}

	/**
	 * Gets the spent amount.
	 *
	 * @return the spent amount
	 */
	public float getSpent() {
		return this.spent;
	}

	/**
	 * Sets the spent amount limit.
	 *
	 * @param spentLimit the new spent amount limit
	 */
	public void setSpentLimit(float spentLimit) {
		this.spentLimit = spentLimit;
	}

	/**
	 * Gets the spent amount limit.
	 *
	 * @return the spent amount limit
	 */
	public float getSpentLimit() {
		return this.spentLimit;
	}

}