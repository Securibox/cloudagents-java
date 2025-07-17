  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * The Enum FieldInputType.
 */
public enum FieldInputType
    {
    
    /** The public. */
    PUBLIC (0),
    
    /** The private. */
    PRIVATE (1),
    
    /** The numberpad. */
    NUMBERPAD (2);

    private final int code;

    FieldInputType(int code) {
        this.code = code;
    }   

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static FieldInputType fromCode(int code) {
        for (FieldInputType type : values()) {
            if (type.code == code)
                return type;
        }
        throw new IllegalArgumentException("Unknown field input type code: " + code + ", please update the sdk.");
    }
  }


