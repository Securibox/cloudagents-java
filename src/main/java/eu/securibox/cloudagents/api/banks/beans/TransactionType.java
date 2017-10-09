package eu.securibox.cloudagents.api.banks.beans;

/**
 * The Enum TransactionType.
 */
public enum TransactionType {

	/** Undefined. */
	Undefined,
	/** Wire transfer. */
	WireTransfer,
	/** Bank payment. */
	BankPayment,
	/** Check. */
	Check,
	/** Withdrawal. */
	Withdrawal,
	/** Credit card payment. */
	CreditCardPayment,
	/** Credit card detailed payment. */
	CreditCardDetailedPayment
}