  /**
   * Copyright (C) 2021 Securibox
   * 
   */

package eu.securibox.cloudagents.api.documents.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * The Enum AgentCurrentState.
 */
public enum AgentCurrentState
{
    
    /** The is running. */
    IS_RUNNING (0),
    
    /** The in maintenance. */
    IN_MAINTENANCE (1),
    
    /** The unavailable. */
    UNAVAILABLE (2);

    private final int code;

    AgentCurrentState(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static AgentCurrentState fromCode(int code) {
        for (AgentCurrentState state : values()) {
            if (state.code == code)
                return state;
        }
        throw new IllegalArgumentException("Unknown agent current state code: " + code + ", please update the sdk.");
    }
}


