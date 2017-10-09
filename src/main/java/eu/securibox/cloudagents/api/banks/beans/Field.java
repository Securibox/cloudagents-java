package eu.securibox.cloudagents.api.banks.beans;
/**
 * The Class Field.
 */
public class Field {
	/** The name of the field. */
	private String name;

	/** The position of the field. */
	private int position;

	/** The hint to be displayed in the field. */
	private String hint;

	/** The Regular Expression to validate the field value. */
	private String regex;

	/** The place holder the should be displayed in the field. */
	private String placeHolder;

	/** The type of input (UI) to be displayed to the end-user. */
	private FieldInputType fieldInputType;

	/** The type of the value expected to be entered in the field. */
	private FieldValueType fieldValueType;

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
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
	 * Sets the position of the field.
	 *
	 * @param position
	 *            the new position
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Gets the position of the field.
	 *
	 * @return the position of the field.
	 */
	public int getPosition() {
		return this.position;
	}

	/**
	 * Sets the hint for this field.
	 *
	 * @param hint
	 *            the new hint
	 */
	public void setHint(String hint) {
		this.hint = hint;
	}

	/**
	 * Gets the hint for this field.
	 *
	 * @return the hint for this field.
	 */
	public String getHint() {
		return this.hint;
	}

	/**
	 * Sets the placeholder for this field.
	 *
	 * @param placeHolder
	 *            the new place holder
	 */
	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	/**
	 * Gets the placeholder for this field.
	 *
	 * @return the placeholder for this field.
	 */
	public String getPlaceHolder() {
		return this.placeHolder;
	}

	/**
	 * Sets the Regular Expression for this field.
	 *
	 * @param regex
	 *            the new regex
	 */
	public void setRegex(String regex) {
		this.regex = regex;
	}

	/**
	 * Gets the Regular Expression for this field.
	 *
	 * @return the Regular Expression for this field.
	 */
	public String getRegex() {
		return this.regex;
	}

	/**
	 * Sets the type of input (UI) to be displayed to the end-user for this
	 * field.
	 *
	 * @param fieldInputType
	 *            the new field input type
	 */
	public void setFieldInputType(FieldInputType fieldInputType) {
		this.fieldInputType = fieldInputType;
	}

	/**
	 * Gets the type of input (UI) to be displayed to the end-user for this
	 * field.
	 *
	 * @return the field input type for this field.
	 */
	public FieldInputType getFieldInputType() {
		return this.fieldInputType;
	}

	/**
	 * Sets the type of the value expected to be entered in the field.
	 *
	 * @param fieldValueType
	 *            the new field value type
	 */
	public void setFieldValueType(FieldValueType fieldValueType) {
		this.fieldValueType = fieldValueType;
	}

	/**
	 * Gets the type of the value expected to be entered in the field.
	 *
	 * @return the type of the value expected to be entered in the field.
	 */
	public FieldValueType getFieldValueType() {
		return this.fieldValueType;
	}
}