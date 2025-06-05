  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.api.documents.beans;

/**
 * Enumeration defining the synchronisation agent process (web scraping).
 */
public enum SynchronizationStateDetails
    {
    
    /** The synchronisation has just been created after an account creation. */
    NEW_ACCOUNT,  
    
    /** The scraping has successfully finished. (green status) */
    COMPLETED, 
    
    /** The scraping has successfully finished but no documents to download have been found. (green status) */
    COMPLETED_NOTHING_TO_DOWNLOAD,
    
    /** The synchronisation has successfully terminated but didn't find any documents to download. (green status) */
    COMPLETED_NOTHING_NEW_TO_DOWNLOAD,
    
    /** The synchronisation has successfully terminated but some documents counldn't be downloaded. (green status) */
    COMPLETED_WITH_MISSING_DOCS,  
    
    /** The synchronisation has successfully terminated but some errors occured. (orange status) */
    COMPLETED_WITH_ERRORS, 
        
    /** The synchronisation has due to incorrect credentials. (red status) */
    WRONG_CREDENTIALS, 
    
    /** Deprecated */
    UNEXPECTED_ACCOUNT_DATA,
        
    /** The synchronisation request has been registered and will occur. */
    SCHEDULED, 
    
    /** The synchronisation is in the queue to be handled. */
    PENDING, 
    
    /** The synchronisation is in progress. */
    IN_PROGRESS, 
    
    /** The user has not activated the electronic invoices. Therefore there is no document available on the website. */
    DEMATERIALISATION_NEEDED, 
    
    /** The account is blocked. No new synchronisation will occur without the account information being updated. */
    CHECK_ACCOUNT,
    
    /** The account has been blocked (too many login tries with a wrong password). */
    ACCOUNT_BLOCKED,
    
    /** The agent web site is requiring the user to go through one more authentication step. */
    ADDITIONAL_AUTHENTICATION_REQUIRED,
    
    /** The login process has changed and the agent is not prepared to handle it. */
    LOGIN_PAGE_CHANGED,
    
    /** The page just after the login phase has changed and the agent is not prepared to handle it. */
    WELCOME_PAGE_CHANGED,
    
    /** The agent web site is in maintenance. */
    WEBSITE_IN_MAINTENANCE,
    
    /** The agent isn't prepared to handle the web site. It seems to have changed. */
    WEBSITE_CHANGED,
    
    /** The agent web site is warning the user that he will have to reset his password in the near future (limited account connexions with same password). */
    RESET_PASSWORD_WARNING,
    
    /** The agent web site requires the password to be reset. */
    RESET_PASSWORD_REQUIRED,
    
    /** The agent web site is unavailable. */
    SERVER_UNAVAILABLE,
    
    /** The web site is requiring the account owner to validate a notification.. */
    PERSONAL_NOTIFICATION,
    
    /** There's a temporary error in the agent web site */
    TEMPORARY_SERVER_ERROR,

    /** A captcha needs to be solved for the agent to perform login */
    CAPTCHA_FOUND,

    /** The credential necessary for multi-factor authentication is wrong */
    WRONG_OPTIONAL_CREDENTIALS,

    /** The secret code for the multi-fact authentication is wrong */
    WRONG_MFA_CODE,

    /** The secret code for the multi-fact authentication has expired */
    EXPIRED_MFA_CODE,

    /** The user has not validated his account yet. */
    ID_PROVIDER_NOT_LINKED_TO_ACCOUNT,

    /** The user has not validated his account yet. */
    PENDING_USER_VALIDATION,

    /** The user has been logged out during the download process. */
    LOGGED_OUT_DURING_DOWNLOAD,

    /** Error with the proxy server */
    PROXY_FAILURE,

    //** Blocked by the protection service */
    BLOCKED_BY_PROTECTION_SERVICE,

    /** The context of the account has expired. */
    CONTEXT_EXPIRED,
    }


