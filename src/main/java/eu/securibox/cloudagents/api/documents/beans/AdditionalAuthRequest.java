package eu.securibox.cloudagents.api.documents.beans;

/**
 * Class to send the additional authentication details.
 *
 */
public class AdditionalAuthRequest {
	private String customerAccountId;
	private String sbxSecretCode;
	/**
	 * Initialises the AdditionalAuthRequest class.
	 * @param customerAccountId the customer account id for which we are providing a secret code
	 * @param sbxSecretCode the secret code sent by another chanel
	 */
	public AdditionalAuthRequest(String customerAccountId, String sbxSecretCode) {
		this.customerAccountId = customerAccountId;
		this.sbxSecretCode = sbxSecretCode;
	}
	/**
	 * Gets the customer account id
	 * @return the customer account id
	 */
	public String getCustomerAccountId() {
		return this.customerAccountId;
	}
	/**
	 * Gets the secret code
	 * @return the secret code
	 */
	public String getSbxSecretCode() {
		return this.sbxSecretCode;
	}
}
