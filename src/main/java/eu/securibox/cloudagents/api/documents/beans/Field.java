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

// TODO: Auto-generated Javadoc
/**
 * The Class Field.
 */
public class Field {
	
	/** The name. */
	private String name;
	
	/** The position. */
	private int position;
	
	/** The hint. */
	private String hint;
	
	/** The place holder. */
	private String placeHolder;
	
	/** The regex. */
	private String regex;
	
	/** The field input type. */
	private FieldInputType fieldInputType;
	
	/** The field value type. */
	private FieldValueType fieldValueType;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public int getPosition() {
		return this.position;
	}

	/**
	 * Gets the hint.
	 *
	 * @return the hint
	 */
	public String getHint() {
		return this.hint;
	}

	/**
	 * Gets the place holder.
	 *
	 * @return the place holder
	 */
	public String getPlaceHolder() {
		return this.placeHolder;
	}

	/**
	 * Gets the regex.
	 *
	 * @return the regex
	 */
	public String getRegex() {
		return this.regex;
	}

	/**
	 * Gets the field input type.
	 *
	 * @return the field input type
	 */
	public FieldInputType getFieldInputType() {
		return this.fieldInputType;
	}

	/**
	 * Gets the field value type.
	 *
	 * @return the field value type
	 */
	public FieldValueType getFieldValueType() {
		return this.fieldValueType;
	}

}
