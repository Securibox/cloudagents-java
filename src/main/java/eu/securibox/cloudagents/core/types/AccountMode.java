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

	@JsonCreator
	public static AccountMode fromString(String name) {
		for (AccountMode mode : values()) {
			if (mode.name().equalsIgnoreCase(name)) {
				return mode;
			}
		}
    throw new IllegalArgumentException("Unknown account mode name: " + name + ", please update the sdk.");
	}
}
