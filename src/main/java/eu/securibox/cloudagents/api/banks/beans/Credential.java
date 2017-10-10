  /**
   * Copyright (C) 2017 Securibox
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
package eu.securibox.cloudagents.api.banks.beans;

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
	 * @param value the encryption algorithm.
	 */
	public void setAlg(String alg){
		if(alg != "none" && alg != "rsa"){
			throw new IllegalArgumentException("The only accepted algorithm values are 'none' or 'rsa'.");
		}
		this.alg = alg;
	}	
}
