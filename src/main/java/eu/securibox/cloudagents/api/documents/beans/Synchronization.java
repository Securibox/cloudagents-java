  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.securibox.cloudagents.core.types.DateDeserializer;

// TODO: Auto-generated Javadoc
/**
 * The Class Synchronization.
 */
public class Synchronization {

	/** The account id. */
	private int accountId;

	/** The customer account id. */
	private String customerAccountId;

	/** The is forced. */
	private boolean isForced;

	/** The downloaded docs. */
	private int downloadedDocs;

	/** The detected docs. */
	private int detectedDocs;

	/** The creation date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date creationDate;

	/** The start date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date startDate;

	/** The end date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date endDate;

	/** The delivery date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date deliveryDate;

	/** The acknowledgement date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date acknowledgementDate;

	/** The synchronization state. */
	private SynchronizationState synchronizationState;

	/** The synchronization state details. */
	private SynchronizationStateDetails synchronizationStateDetails;

	/** The synchronization mode. */
	private SynchronizationMode synchronizationMode;

	/** The api version. */
	private String apiVersion;

	/** The documents. */
	private List<Document> documents;

	/**
	 * Gets the account id.
	 *
	 * @return the account id
	 */
	public int getAccountId() {
		return this.accountId;
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
	 * Gets the checks if is forced.
	 *
	 * @return the checks if is forced
	 */
	public boolean getIsForced() {
		return this.isForced;
	}

	/**
	 * Gets the downloaded docs.
	 *
	 * @return the downloaded docs
	 */
	public int getDownloadedDocs() {
		return this.downloadedDocs;
	}

	/**
	 * Gets the detected docs.
	 *
	 * @return the detected docs
	 */
	public int getDetectedDocs() {
		return this.detectedDocs;
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
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return this.endDate;
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
	 * Gets the acknowledgement date.
	 *
	 * @return the acknowledgement date
	 */
	public Date getAcknowledgementDate() {
		return this.acknowledgementDate;
	}

	/**
	 * Gets the synchronization state.
	 *
	 * @return the synchronization state
	 */
	public SynchronizationState getSynchronizationState() {
		return this.synchronizationState;
	}

	/**
	 * Gets the synchronization state details.
	 *
	 * @return the synchronization state details
	 */
	public SynchronizationStateDetails getSynchronizationStateDetails() {
		return this.synchronizationStateDetails;
	}

	/**
	 * Gets the synchronization mode.
	 *
	 * @return the synchronization mode
	 */
	public SynchronizationMode getSynchronizationMode() {
		return this.synchronizationMode;
	}

	/**
	 * Gets the api version.
	 *
	 * @return the api version
	 */
	public String getApiVersion() {
		return this.apiVersion;
	}

	/**
	 * Gets the documents.
	 *
	 * @return the documents
	 */
	public List<Document> getDocuments() {
		return this.documents;
	}
}
