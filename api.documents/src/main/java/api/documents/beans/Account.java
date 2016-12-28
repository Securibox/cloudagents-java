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

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Account.
 */
public class Account {
	
	/** The customer account id. */
	private String customerAccountId;
	
	/** The customer user id. */
	private String customerUserId;
	
	/** The name. */
	private String name;
	
	/** The agent id. */
	private String agentId;
	
	/** The credentials. */
	private List<Credential> credentials;

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
	 * Gets the customer user id.
	 *
	 * @return the customer user id
	 */
	public String getCustomerUserId() {
		return this.customerUserId;
	}

	/**
	 * Sets the customer user id.
	 *
	 * @param customerUserId the new customer user id
	 */
	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
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
	 * Gets the agent id.
	 *
	 * @return the agent id
	 */
	public String getAgentId() {
		return this.agentId;
	}

	/**
	 * Sets the agent id.
	 *
	 * @param agentId the new agent id
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	
	/**
	 * Sets the credentials.
	 *
	 * @param credentials the new credentials
	 */
	public void setCredentials(List<Credential> credentials) {
		this.credentials = credentials;
	}

	/**
	 * Gets the credentials.
	 *
	 * @return the credentials
	 */
	public List<Credential> getCredentials() {
		return this.credentials;
	}
}
