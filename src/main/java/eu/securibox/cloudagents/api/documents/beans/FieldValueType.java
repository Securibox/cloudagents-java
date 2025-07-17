  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * The Enum FieldValueType.
 */
public enum FieldValueType
  {
    
    /** The fulltext. */
    FULLTEXT (0),
    
    /** The password. */
    PASSWORD (1),
    
    /** The email. */
    EMAIL (2),
    
    /** The telephone. */
    TELEPHONE (3);

    private final int code;
    FieldValueType(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static FieldValueType fromCode(int code) {
        for (FieldValueType type : values()) {
            if (type.code == code)
                return type;
        }
        throw new IllegalArgumentException("Unknown field value type code: " + code + ", please update the sdk.");
    }
  }


