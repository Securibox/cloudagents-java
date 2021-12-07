package eu.securibox.cloudagents.api.documents.beans;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.securibox.cloudagents.core.types.DateDeserializer;
/**
 * Multifactor authentication details.
 *
 */
public class AdditionalAuthData {

	private String additionalAuthenticationType;
	@JsonDeserialize(using = DateDeserializer.class)
	private Date expirationDate;
	private String message;
	
	/**
	 * Channel to communicate the secret code
	 * @return A string specifying the channel to which the code has been sent to.
	 */
	public String getAdditionalAuthenticationType() {
		return this.additionalAuthenticationType;
	}
	/**
	 * Gets the code validity date
	 * @return the code validity date
	 */
	public Date getExpirationDate() {
		return this.expirationDate;
	}
	/**
	 * Gets the message sent by the agent
	 * @return message sent by the agent
	 */
	public String getMessage() {
		return this.message;
	}
}
