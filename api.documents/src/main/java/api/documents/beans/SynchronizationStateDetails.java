  /**
   * Copyright (C) 2016 Securibox
   * 
   * This program is free software: you can redistribute it and/or modify 
   * it under the terms of the GNU General Public License as published by 
   * the Free Software Foundation, either version 3 of the License, or 
   * (at your option) any later version.
   * 
   * This program is distributed in the hope that it will be useful, 
   * but WITHOUT ANY WARRANTY; without even the implied warranty of 
   * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
   * GNU General Public License for more details.
   * 
   * You should have received a copy of the GNU General Public License 
   * along with this program.  If not, see <http://www.gnu.org/licenses/>.
   */

package api.documents.beans;

// TODO: Auto-generated Javadoc
/**
 * The Enum SynchronizationStateDetails.
 */
public enum SynchronizationStateDetails
    {
    
    /** The new account. */
    NEW_ACCOUNT,  
    
    /** The completed. */
    COMPLETED, 
    
    /** The completed nothing to download. */
    COMPLETED_NOTHING_TO_DOWNLOAD,
    
    /** The completed nothing new to download. */
    COMPLETED_NOTHING_NEW_TO_DOWNLOAD,
    
    /** The completed with missing docs. */
    COMPLETED_WITH_MISSING_DOCS,  
    
    /** The completed with errors. */
    COMPLETED_WITH_ERRORS, 
        
    /** The wrong credentials. */
    WRONG_CREDENTIALS, 
    
    /** The unexpected account data. */
    UNEXPECTED_ACCOUNT_DATA,
        
        /** The scheduled. */
        SCHEDULED, 
    
    /** The pending. */
    PENDING, 
    
    /** The in progress. */
    IN_PROGRESS, 
    
    /** The dematerialisation needed. */
    DEMATERIALISATION_NEEDED, 
    
    /** The check account. */
    CHECK_ACCOUNT,
    
    /** The account blocked. */
    ACCOUNT_BLOCKED,
    
    /** The additional authentication required. */
    ADDITIONAL_AUTHENTICATION_REQUIRED,
    
    /** The login page changed. */
    LOGIN_PAGE_CHANGED,
    
    /** The welcome page changed. */
    WELCOME_PAGE_CHANGED,
    
    /** The website in maintenance. */
    WEBSITE_IN_MAINTENANCE,
    
    /** The website changed. */
    WEBSITE_CHANGED,
    
    /** The reset password warning. */
    RESET_PASSWORD_WARNING,
    
    /** The reset password required. */
    RESET_PASSWORD_REQUIRED,
    
    /** The server unavailable. */
    SERVER_UNAVAILABLE,
    
    /** The personal notification. */
    PERSONAL_NOTIFICATION
    }


