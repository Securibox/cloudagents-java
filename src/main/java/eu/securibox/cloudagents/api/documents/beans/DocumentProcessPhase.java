  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * The Enum DocumentProcessPhase.
 */
public enum DocumentProcessPhase
    {
    
    /** The toparse. */
    TOPARSE (0),
    
    /** The todeliver. */
    TODELIVER (1),
    
    /** The packaged. */
    PACKAGED (2),
    
    /** The delivered. */
    DELIVERED (3),
    
    /** The acknowledged. */
    ACKNOWLEDGED (4),
    
    /** The acknowledgementfailed. */
    ACKNOWLEDGEMENTFAILED (5),
    
    /** The deliveryfailed. */
    DELIVERYFAILED (6),

    /** The holding */
    HOLDING (7),

    /** The parsing */
    PARSING (8),

    /** The topack */
    TOPACK (9);

    private final int code;

    DocumentProcessPhase(int code) {
        this.code = code;
    }   

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static DocumentProcessPhase fromCode(int code) {
        for (DocumentProcessPhase phase : values()) {
            if (phase.code == code)
                return phase;
        }
        throw new IllegalArgumentException("Unknown document process phase code: " + code + ", please update the sdk.");
    }
  }


