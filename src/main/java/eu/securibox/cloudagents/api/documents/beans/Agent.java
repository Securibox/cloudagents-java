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

package eu.securibox.cloudagents.api.documents.beans;
import java.util.Date;
import java.util.List;

import eu.securibox.cloudagents.core.types.CountryCode;
import eu.securibox.cloudagents.core.types.DateDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// TODO: Auto-generated Javadoc
/**
 * The Class Agent.
 */
public class Agent {	
	
	/** The id. */
	private String id;
	
	/** The is enabled. */
	private boolean isEnabled;
	
	/** The name. */
	private String name;
	
	/** The display name. */
	private String displayName;
	
	/** The description. */
	private String description;
	
	/** The agent periodicity. */
	private AgentPeriodicity agentPeriodicity;
	
	/** The agent current state. */
	private AgentCurrentState agentCurrentState;
	
	/** The default category. */
	private String defaultCategory;
	
	/** The category id. */
	private String categoryId;
	
	/** The is tracked. */
	private boolean isTracked;
	
	/** The logos. */
	private AgentLogos logos;
	
	/** The base64 logo. */
	private String base64Logo;
	
	/** The country codes. */
	private CountryCode[] countryCodes;
	
	/** The url. */
	private String url;
	
	/** The document types. */
	private String documentTypes;
	
	/** The fields. */
	private List<Field> fields;
	
	/** The category. */
	private String category;
	
	/** The creation date. */
	@JsonDeserialize(using = DateDeserializer.class)
	private Date creationDate;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Gets the checks if is enabled.
	 *
	 * @return the checks if is enabled
	 */
	public boolean getIsEnabled() {
		return this.isEnabled;
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
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the agent periodicity.
	 *
	 * @return the agent periodicity
	 */
	public AgentPeriodicity getAgentPeriodicity() {
		return this.agentPeriodicity;
	}

	/**
	 * Gets the agent current state.
	 *
	 * @return the agent current state
	 */
	public AgentCurrentState getAgentCurrentState() {
		return this.agentCurrentState;
	}

	/**
	 * Gets the default category.
	 *
	 * @return the default category
	 */
	public String getDefaultCategory() {
		return this.defaultCategory;
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public String getCategoryId() {
		return this.categoryId;
	}

	/**
	 * Gets the checks if is tracked.
	 *
	 * @return the checks if is tracked
	 */
	public boolean getIsTracked() {
		return this.isTracked;
	}

	/**
	 * Gets the logos.
	 *
	 * @return the logos
	 */
	public AgentLogos getLogos() {
		return this.logos;
	}

	/**
	 * Gets the base64 logo.
	 *
	 * @return the base64 logo
	 */
	public String getBase64Logo() {
		return this.base64Logo;
	}

	/**
	 * Gets the country codes.
	 *
	 * @return the country codes
	 */
	public CountryCode[] getCountryCodes() {
		return this.countryCodes;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Gets the document types.
	 *
	 * @return the document types
	 */
	public String getDocumentTypes() {
		return this.documentTypes;
	}

	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public List<Field> getFields() {
		return this.fields;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return this.category;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}
}
