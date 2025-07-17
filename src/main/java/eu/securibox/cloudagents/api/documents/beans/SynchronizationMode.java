  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * The Enum SynchronizationMode.
 */
public enum SynchronizationMode {
	
	/** The newaccount. */
	NEWACCOUNT (0), 
	
	/** The client. */
	CLIENT (1), 
	
	/** The automatic. */
	AUTOMATIC (2),

	//** Admin mode */
	ADMIN (3);

	private final int code;
	SynchronizationMode(int code) {
		this.code = code;
	}

	@JsonValue
	public int getCode() {
		return code;
	}

	@JsonCreator
	public static SynchronizationMode fromCode(int code) {
		for (SynchronizationMode mode : values()) {
			if (mode.code == code)
				return mode;
		}
		throw new IllegalArgumentException("Unknown synchronization mode code: " + code + ", please update the sdk.");
	}
}
