  /**
   * Copyright (C) 2021 Securibox
   */

package eu.securibox.cloudagents.api.documents.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * The Enum AgentPeriodicity.
 */

public enum AgentPeriodicity
  {
    /** The hard weekly. */
    HARD_WEEKLY (0),

    /** The hard monthly. */
    HARD_MONTHLY (1),
    
    /** The daily. */
    DAILY (2),
    
    /** The weekly. */
    WEEKLY (3),
    
    /** The biweekly. */
    BIWEEKLY (4),
    
    /** The monthly. */
    MONTHLY (5),
    
    /** The bimonthly. */
    BIMONTHLY (6),
    
    /** The trimonthly. */
    TRIMONTHLY (7),
    
    /** The sixmonthly. */
    SIXMONTHLY (8),
    
    /** The yearly. */
    YEARLY (9),

    /** The hard biweekly. */
    HARD_BIWEEKLY (10),

    /** The hard bimonthly. */
    HARD_BIMONTHLY (11),

    /** The hard trimonthly. */
    HARD_TRIMONTHLY (12),

    /** The hard sixmonthly. */
    HARD_SIXMONTHLY (13),

    /** The hard yearly. */
    HARD_YEARLY (14);

    private final int code;

    AgentPeriodicity(int code) {
        this.code = code;
    }

    @JsonValue

    public int getCode() {
        return code;
    }

    @JsonCreator
    public static AgentPeriodicity fromCode(int code) 
    {
        for (AgentPeriodicity periodicity : values()) 
        {
            if (periodicity.code == code)
                return periodicity;
        }
        throw new IllegalArgumentException("Unknown agent periodicity code: " + code + ", please update the sdk.");
    }
  }