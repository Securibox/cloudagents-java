  /**
   * Copyright (C) 2021 Securibox
   */

package eu.securibox.cloudagents.api.documents.beans;

import java.util.Date;
import java.util.Dictionary;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.securibox.cloudagents.core.types.DateDeserializer;

// TODO: Auto-generated Javadoc
/**
 * The Class Document.
 */
public class Document {
	
	/** The id. */
	private long id;
	
	/** The name. */
	private String name;

	/** The synch creation date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date synchCreationDate;
	
	/** The customer account id. */
	private String customerAccountId;
	
	/** The customer user id. */
	private String customerUserId;
	
	/** The content hash. */
	private String contentHash;
	
	/** The hash algorithm. */
	private String hashAlgorithm;
	
	/** The content type. */
	private String contentType;
	
	/** The metadata. */
	private Dictionary<String, String> metadata;
	
	/** The unique identifier. */
	private String uniqueIdentifier;
	
	/** The unique identifier hash. */
	private String uniqueIdentifierHash;
	
	/** The document process phase. */
	private DocumentProcessPhase documentProcessPhase;
	
	/** The size. */
	private int size;

	/** The delivery date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date deliveryDate;

	/** The acknowledgement date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date acknowledgementDate;
	
	/** The base64 content. */
	private String base64Content;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the synch creation date.
	 *
	 * @return the synch creation date
	 */
	public Date getSynchCreationDate() {
		return this.synchCreationDate;
	}

	/**
	 * Sets the synch creation date.
	 *
	 * @param synchCreationDate the new synch creation date
	 */
	public void setSynchCreationDate(Date synchCreationDate) {
		this.synchCreationDate = synchCreationDate;
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
	 * Sets the customer account id.
	 *
	 * @param customerAccountId the new customer account id
	 */
	public void setCustomerAccountId(String customerAccountId) {
		this.customerAccountId = customerAccountId;
	}

	/**
	 * Gets the content hash.
	 *
	 * @return the content hash
	 */
	public String getContentHash() {
		return this.contentHash;
	}

	/**
	 * Gets the hash algorithm.
	 *
	 * @return the hash algorithm
	 */
	public String getHashAlgorithm() {
		return this.hashAlgorithm;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContentType() {
		return this.contentType;
	}

	/**
	 * Gets the metadata.
	 *
	 * @return the metadata
	 */
	public Dictionary<String, String> getMetadata() {
		return this.metadata;
	}

	/**
	 * Gets the unique identifier.
	 *
	 * @return the unique identifier
	 */
	public String getUniqueIdentifier() {
		return this.uniqueIdentifier;
	}

	/**
	 * Gets the unique identifier hash.
	 *
	 * @return the unique identifier hash
	 */
	public String getUniqueIdentifierHash() {
		return this.uniqueIdentifierHash;
	}

	/**
	 * Gets the document process phase.
	 *
	 * @return the document process phase
	 */
	public DocumentProcessPhase getDocumentProcessPhase() {
		return this.documentProcessPhase;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return this.size;
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
	 * Gets the base64 content.
	 *
	 * @return the base64 content
	 */
	public String getBase64Content() {
		return this.base64Content;
	}
	
	/**
	 * Gets the customer user id
	 *
	 * @return the customer user id
	 */
	public String getCustomerUserId() {
		return this.customerUserId;
	}

}
