  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * The Enum SynchronizationState.
 */
public enum SynchronizationState
{
    
    /** The new account. */
    NEW_ACCOUNT (0),
    
    /** The created. */
    CREATED (1),
    
    /** The running. */
    RUNNING (2),
    
    /** The documents are waiting to be delivered */
    TO_DELIVER (3),
    
    /** The delivering. */
    DELIVERING (4),
    
    /** The pending acknowledgement. */
    PENDING_ACKNOWLEDGEMENT (5),
    
    /** The completed. */
    COMPLETED (6),
    
    /** The report failed. */
    REPORT_FAILED (7),
    
    /** The synchronization hasn't been acknowledged */
    NOT_ACK (8),

    /** The account is blocked */
    BLOCKED (9);

    private final int code;

    SynchronizationState(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static SynchronizationState fromCode(int code) {
        for (SynchronizationState state : values()) {
            if (state.code == code)
                return state;
        }
        throw new IllegalArgumentException("Unknown synchronization state code: " + code + ", please update the sdk.");
    }
}


