package eu.securibox.cloudagents.core.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountMode 
{
	Enabled (0),

	Disabled (1),

	NoAutomaticSynch (2),

	MfaAutoSynch (3);

	private final int code;

	AccountMode(int code) {
		this.code = code;
	}

	@JsonValue
	public int getCode() {
		return code;
	}

	@JsonCreator
	public static AccountMode fromCode(int code) {
		for (AccountMode mode : values()) {
			if (mode.code == code)
				return mode;
		}
		throw new IllegalArgumentException("Unknown account mode code: " + code + ", please update the sdk.");
	}
}
