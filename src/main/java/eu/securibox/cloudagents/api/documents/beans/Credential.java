  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

public class Credential {
	public Credential(){}
	
	private String alg;
	
	/** The position. */
	private int position;
	
	/** The value. */
	private String value;
	
	/**
	 * Instantiates a new credential.
	 *
	 * @param position the position
	 * @param value the value
	 */
	public Credential(int position, String value){
		this.position = position;
		this.value = value;
		this.alg = "none";
	}
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public int getPosition(){
		return this.position;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue(){
		return this.value;
	}
	
	/**
	 * Gets the encryption algorithm.
	 *
	 * @return the encryption algorithm.
	 */
	public String getAlg(){
		return this.alg;
	}	
	
	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(int position){
		this.position = position;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value){
		this.value = value;
	}
	
	/**
	 * Sets the encryption algorithm.
	 *
	 * @param alg the encryption algorithm.
	 */
	public void setAlg(String alg){
		if(alg != null && !"none".equals(alg) && !"rsa".equals(alg)){
			throw new IllegalArgumentException("The only accepted algorithm values are 'none' or 'rsa'.");
		}
		this.alg = alg;
	}	
}
