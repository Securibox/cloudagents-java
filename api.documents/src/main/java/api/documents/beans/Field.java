package api.documents.beans;

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
