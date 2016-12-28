  /**
   * Copyright (C) 2016 Securibox
   * 
   * This program is free software: you can redistribute it and/or modify 
   * it under the terms of the GNU General Public License as published by 
   * the Free Software Foundation, either version 3 of the License, or 
   * (at your option) any later version.
   * 
   * This program is distributed in the hope that it will be useful, 
   * but WITHOUT ANY WARRANTY; without even the implied warranty of 
   * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
   * GNU General Public License for more details.
   * 
   * You should have received a copy of the GNU General Public License 
   * along with this program.  If not, see <http://www.gnu.org/licenses/>.
   */

package api.documents.beans;

import java.util.Date;
import java.util.Dictionary;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import core.impl.DateDeserializer;

// TODO: Auto-generated Javadoc
/**
 * The Class Document.
 */
public class Document {
	
	/** The id. */
	private int id;
	
	/** The name. */
	private String name;

	/** The synch creation date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date synchCreationDate;
	
	/** The customer account id. */
	private String customerAccountId;
	
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
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
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

}
