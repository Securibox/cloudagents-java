package eu.securibox.cloudagents.api.banks.beans;

/**
 * The Enum SynchronizationState.
 */
public enum SynchronizationState {
	
	/** New account. */
	NewAccount,
	
	/** Created. */
	Created,
	
	/** Running. */
	Running,
	
	/** Login failed. */
	LoginFailed,
	
	/** Completed. */
	Completed,
	
	/** Completed with errors. */
	CompletedWithErrors,
	
	/** Check account. */
	CheckAccount,
	
	/** Service unavailable. */
	ServiceUnavailable,
	
	/** Logging in. */
	LoggingIn,
	
	/** Running but login failed. */
	RunningButLoginFailed,
	
	/** Delivery failed. */
	DeliveryFailed,
	
	/** The web site in maintenance */
	WebsiteInMaintenance,
	
	/** A reset password warning is being displayed. */
	ResetPasswordWarning,
	
	/** The user must reset the password. */
	ResetPasswordRequired,
	
	/** There's s personal notification requiring an action by the user. */
	UserActionNeeded
}
