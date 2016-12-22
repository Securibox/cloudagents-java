package api.documents.managers;

import java.util.Date;
import java.util.List;

import api.documents.beans.Account;
import api.documents.beans.Document;
import api.documents.beans.Synchronization;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;

/**
 * The Interface AccountManager.
 */
public interface AccountManager {

/**
 * Creates the account.
 *
 * @param account the account
 * @param synchronize the synchronize
 * @return the account
 * @throws ClientException the client exception
 * @throws ResponseException the response exception
 */
public Account createAccount(Account account, boolean synchronize) throws ClientException, ResponseException;

/**
 * List accounts.
 *
 * @param agentId the agent id
 * @param customerUserId the customer user id
 * @param skip the skip
 * @param take the take
 * @return the list
 * @throws ClientException the client exception
 * @throws ResponseException the response exception
 */
public List<Account> listAccounts(String agentId, String customerUserId, int skip, int take) throws ClientException, ResponseException;

/**
 * Gets the account.
 *
 * @param customerAccountId the customer account id
 * @return the account
 * @throws ClientException the client exception
 * @throws ResponseException the response exception
 */
public Account getAccount(String customerAccountId) throws ClientException, ResponseException;

/**
 * Update account.
 *
 * @param account the account
 * @return the account
 * @throws ClientException the client exception
 * @throws ResponseException the response exception
 */
public Account updateAccount(Account account) throws ClientException, ResponseException;

/**
 * Delete account.
 *
 * @param customerAccountId the customer account id
 * @throws ClientException the client exception
 * @throws ResponseException the response exception
 */
public void deleteAccount(String customerAccountId) throws ClientException, ResponseException;

/**
 * List documents by account.
 *
 * @param customerAccountId the customer account id
 * @param pendingOnly the pending only
 * @param includeContent the include content
 * @return the list
 * @throws ClientException the client exception
 * @throws ResponseException the response exception
 */
public List<Document> listDocumentsByAccount(String customerAccountId, boolean pendingOnly, boolean includeContent) throws ClientException, ResponseException;

/**
 * List synchronizations by account.
 *
 * @param customerAccountId the customer account id
 * @param startDate the start date
 * @param endDate the end date
 * @return the list
 * @throws ClientException the client exception
 * @throws ResponseException the response exception
 */
public List<Synchronization> listSynchronizationsByAccount(String customerAccountId, Date startDate, Date endDate) throws ClientException, ResponseException;

/**
 * Gets the last synchronization of account.
 *
 * @param customerAccountId the customer account id
 * @return the last synchronization of account
 * @throws ClientException the client exception
 * @throws ResponseException the response exception
 */
public Synchronization getLastSynchronizationOfAccount(String customerAccountId) throws ClientException, ResponseException;

/**
 * Synchronize account.
 *
 * @param customerAccountId the customer account id
 * @param isForced the is forced
 * @return the synchronization
 * @throws ClientException the client exception
 * @throws ResponseException the response exception
 */
public Synchronization synchronizeAccount(String customerAccountId, boolean isForced) throws ClientException, ResponseException;
}
