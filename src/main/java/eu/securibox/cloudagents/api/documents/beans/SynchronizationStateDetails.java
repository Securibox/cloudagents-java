  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeration defining the synchronisation agent process (web scraping).
 */
public enum SynchronizationStateDetails
{
    
    /** The synchronisation has just been created after an account creation. */
    NEW_ACCOUNT (0),  
    
    /** The scraping has successfully finished. (green status) */
    COMPLETED (1), 
    
    /** The scraping has successfully finished but no documents to download have been found. (green status) */
    COMPLETED_NOTHING_TO_DOWNLOAD (2),
    
    /** The synchronisation has successfully terminated but didn't find any documents to download. (green status) */
    COMPLETED_NOTHING_NEW_TO_DOWNLOAD (3),
    
    /** The synchronisation has successfully terminated but some documents counldn't be downloaded. (green status) */
    COMPLETED_WITH_MISSING_DOCS (4),  
    
    /** The synchronisation has successfully terminated but some errors occured. (orange status) */
    COMPLETED_WITH_ERRORS (5), 
        
    /** The synchronisation has due to incorrect credentials. (red status) */
    WRONG_CREDENTIALS (6), 
    
    /** Deprecated */
    UNEXPECTED_ACCOUNT_DATA (7),
        
    /** The synchronisation request has been registered and will occur. */
    SCHEDULED (8), 
    
    /** The synchronisation is in the queue to be handled. */
    PENDING (9), 
    
    /** The synchronisation is in progress. */
    IN_PROGRESS (10), 
    
    /** The user has not activated the electronic invoices. Therefore there is no document available on the website. */
    DEMATERIALISATION_NEEDED (11), 
    
    /** The account is blocked. No new synchronisation will occur without the account information being updated. */
    CHECK_ACCOUNT (12),
    
    /** The account has been blocked (too many login tries with a wrong password). */
    ACCOUNT_BLOCKED (13),
    
    /** The agent web site is requiring the user to go through one more authentication step. */
    ADDITIONAL_AUTHENTICATION_REQUIRED (14),
    
    /** The login process has changed and the agent is not prepared to handle it. */
    LOGIN_PAGE_CHANGED (15),
    
    /** The page just after the login phase has changed and the agent is not prepared to handle it. */
    WELCOME_PAGE_CHANGED (16),
    
    /** The agent web site is in maintenance. */
    WEBSITE_IN_MAINTENANCE (17),
    
    /** The agent isn't prepared to handle the web site. It seems to have changed. */
    WEBSITE_CHANGED (18),
    
    /** The agent web site is warning the user that he will have to reset his password in the near future (limited account connexions with same password). */
    RESET_PASSWORD_WARNING (19),
    
    /** The agent web site requires the password to be reset. */
    RESET_PASSWORD_REQUIRED (20),
    
    /** The agent web site is unavailable. */
    SERVER_UNAVAILABLE (21),
    
    /** The web site is requiring the account owner to validate a notification.. */
    PERSONAL_NOTIFICATION (22),
    
    /** There's a temporary error in the agent web site */
    TEMPORARY_SERVER_ERROR (23),

    /** A captcha needs to be solved for the agent to perform login */
    CAPTCHA_FOUND (24),

    /** The credential necessary for multi-factor authentication is wrong */
    WRONG_OPTIONAL_CREDENTIALS (25),

    /** The secret code for the multi-fact authentication is wrong */
    WRONG_MFA_CODE (26),

    /** The secret code for the multi-fact authentication has expired */
    EXPIRED_MFA_CODE (27),

    /** The user has not validated his account yet. */
    ID_PROVIDER_NOT_LINKED_TO_ACCOUNT (28),

    /** The user has not validated his account yet. */
    PENDING_USER_VALIDATION (29),

    /** The user has been logged out during the download process. */
    LOGGED_OUT_DURING_DOWNLOAD (30),

    /** Error with the proxy server */
    PROXY_FAILURE (31),

    //** Blocked by the protection service */
    BLOCKED_BY_PROTECTION_SERVICE (32),

    /** The context of the account has expired. */
    CONTEXT_EXPIRED (33);

    private final int code;
    SynchronizationStateDetails(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static SynchronizationStateDetails fromCode(int code) {
        for (SynchronizationStateDetails state : values()) {
            if (state.code == code)
                return state;
        }
        throw new IllegalArgumentException("Unknown synchronization state details code: " + code + ", please update the sdk.");
    }
  }