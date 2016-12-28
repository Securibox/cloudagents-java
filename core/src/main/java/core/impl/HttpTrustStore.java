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

package core.impl;

import core.TrustStore;

// TODO: Auto-generated Javadoc
/**
 * The Class HttpTrustStore.
 */
public class HttpTrustStore implements TrustStore {

	/** The filename. */
	private String filename;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new http trust store.
	 *
	 * @param filename
	 *            the filename
	 * @param password
	 *            the password
	 */
	public HttpTrustStore(String filename, String password) {
		if (Utils.nullOrEmpty(filename))
			throw new IllegalArgumentException("The filename cannot be null or empty");
		this.filename = filename;
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.TrustStore#getFilename()
	 */
	public String getFilename() {
		return this.filename;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see core.TrustStore#getPassword()
	 */
	public String getPassword() {
		return this.password;
	}

}
