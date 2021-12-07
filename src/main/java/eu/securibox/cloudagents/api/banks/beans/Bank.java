  /**
   * Copyright (C) 2017 Securibox
   * 
   */
package eu.securibox.cloudagents.api.banks.beans;

import java.util.ArrayList;
import java.util.List;

import eu.securibox.cloudagents.core.types.CountryCode;

/**
 * The Class Bank.
 */
public class Bank {
	
	/** The id. */
	private String id;
	
	/** The name. */
	private String name;
	
	/** The branch name. */
	private String branchName;
	
	/** The display name. */
	private String displayName;
	
	/** The national bank code. */
	private String nationalBankCode;
	
	/**  The bank country codes. */
	private CountryCode[] countryCodes;
	
	/** The login url. */
	private String loginUrl;
	
	/** The status. */
	private AgentCurrentState status;
	
	/** The bank web site fields to login. */
	private List<Field> fields;
	
	
	/**
	 * Instantiates a new bank.
	 */
	public Bank(){
		fields = new ArrayList<Field>();
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return this.id;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the new branch name
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Gets the branch name.
	 *
	 * @return the branch name
	 */
	public String getBranchName() {
		return this.branchName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
	 * Sets the national bank code.
	 *
	 * @param nationalBankCode the new national bank code
	 */
	public void setNationalBankCode(String nationalBankCode) {
		this.nationalBankCode = nationalBankCode;
	}

	/**
	 * Gets the national bank code.
	 *
	 * @return the national bank code
	 */
	public String getNationalBankCode() {
		return this.nationalBankCode;
	}

	/**
	 * Sets the country.
	 *
	 * @param countryCodes the new country
	 */
	public void setCountry(CountryCode[] countryCodes) {
		this.countryCodes = countryCodes;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public CountryCode[] getCountryCodes() {
		return this.countryCodes;
	}

	/**
	 * Sets the login url.
	 *
	 * @param loginUrl the new login url
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	/**
	 * Gets the login url.
	 *
	 * @return the login url
	 */
	public String getLoginUrl() {
		return this.loginUrl;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(AgentCurrentState status) {
		this.status = status;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public AgentCurrentState getStatus() {
		return this.status;
	}
	
	/**
	 * Sets the fields.
	 *
	 * @param fields the new fields
	 */
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public List<Field> getFields() {
		return this.fields;
	}

}
