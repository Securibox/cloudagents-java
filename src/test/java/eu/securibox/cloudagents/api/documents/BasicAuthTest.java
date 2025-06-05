package eu.securibox.cloudagents.api.documents;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import eu.securibox.cloudagents.api.documents.beans.Account;
import eu.securibox.cloudagents.api.documents.beans.Agent;
import eu.securibox.cloudagents.api.documents.beans.Category;
import eu.securibox.cloudagents.api.documents.beans.Credential;
import eu.securibox.cloudagents.api.documents.beans.Document;
import eu.securibox.cloudagents.api.documents.beans.Synchronization;
import eu.securibox.cloudagents.api.documents.beans.SynchronizationState;
import eu.securibox.cloudagents.core.SecurityConfiguration;
import eu.securibox.cloudagents.core.configuration.SSLConfiguration;
import eu.securibox.cloudagents.core.exceptions.ClientException;
import eu.securibox.cloudagents.core.exceptions.ResponseException;
import eu.securibox.cloudagents.core.types.AccountMode;
import eu.securibox.cloudagents.core.types.CountryCode;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasicAuthTest {

	static final String agentId = "93FDDB673A2D4FB49406F21A5937DC90";
	static final String customerUserId = "UNITTESTS_JAVA_SDK";
	static final String customerAccountId = "UNITTESTS_JAVA_SDK_UID";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SecurityConfiguration systConfig = SSLConfiguration.Basic(null, "username", "password");
		ApiClient.ConfigureClient("https://localhost:8080/api/v1", systConfig);
	}
	//@AfterClass
	public static void ClearCreatedAccounts() throws Exception {
		List<Account> accounts = ApiClient.getAccountManager().listAccounts(null, BasicAuthTest.customerUserId, 0, 0);
		for(Account account : accounts) {
			ApiClient.getAccountManager().deleteAccount(account.getCustomerAccountId());
		}
		
	}

	@Test
	public void A1_GetAgentsListTest() throws ClientException, ResponseException, UnsupportedEncodingException {
		List<Agent> agents = ApiClient.getAgentManager().listAgents();
		assertTrue(agents.size()>0);
	}
	
	@Test
	public void A2_GetNonExistingAgentByIdTest() throws ClientException, ResponseException {
		Agent agent = ApiClient.getAgentManager().getAgentByIdentifier("UnexistingAgentId");
		Assert.assertNull(agent);
	}
	
	@Test
	public void A3_SearchAgentsTest() throws ClientException, ResponseException, UnsupportedEncodingException {
		List<Agent> agents = ApiClient.getAgentManager().searchAgents(CountryCode.FR, null, false,null, false);
		assertTrue(agents.size()>0);
		agents = ApiClient.getAgentManager().searchAgents(null, "fr-FR", false,null,false);
		assertTrue(agents.size()>0);
		agents = ApiClient.getAgentManager().searchAgents(null, null, false,"Prixtel",false);
		assertTrue(agents.size()>0);
		agents = ApiClient.getAgentManager().searchAgents(null, null, false,"Non-existant agent name", false);
		assertTrue(agents.size() == 0);
		agents = ApiClient.getAgentManager().searchAgents(CountryCode.AD, null, false,null,false);
		assertTrue(agents.size() == 0);
	}
	
	@Test
	public void B1_GetCategoriesListTest() throws ClientException, ResponseException, UnsupportedEncodingException {
		List<Category> categories = ApiClient.getCategoryManager().ListCategories(null);
		assertTrue(categories.size()>0);
	}
	
	@Test
	public void B2_GetCategoriesAndListAgentsByCategoryTest() throws ClientException, ResponseException, UnsupportedEncodingException {
		List<Category> categories = ApiClient.getCategoryManager().ListCategories(null);
		assertTrue(categories.size()>0);
		for(Category category : categories) {
			List<Agent> agents = ApiClient.getCategoryManager().ListAgentsByCategory(category.getId());
			assertTrue(agents.size()>=0);
		}
	}
		

	@Test
	public void C2_createAccount() throws ClientException{
		Account account = new Account(); //Create account for FakeAgent
		account.setAgentId(BasicAuthTest.agentId);
		account.setCustomerUserId(BasicAuthTest.customerUserId);
		account.setCustomerAccountId(BasicAuthTest.customerAccountId);
		account.setName("FakeAgent Java SDK Test");
		account.setMode(AccountMode.Enabled);
		
		Credential userName = new Credential(0, "username");
		Credential password = new Credential(1, "password");
		
		account.getCredentials().add(userName);
		account.getCredentials().add(password);
		Account returnedAccount = null;
		try{
			returnedAccount = ApiClient.getAccountManager().createAccount(account, false);
		}catch(ResponseException ex){
			ex.toString();
		}
		assertNotNull(returnedAccount);
	}
	
	@Test
	public void C3_listAccountsForCustomer() throws ClientException, ResponseException, UnsupportedEncodingException {
		List<Account> accounts = ApiClient.getAccountManager().listAccounts(null, BasicAuthTest.customerUserId, 0, 0);
		assertTrue(accounts.size()>0);
	}
	
	@Test
	public void C4_listAccountsForAgent() throws ClientException, ResponseException, UnsupportedEncodingException {
		List<Account> accounts = ApiClient.getAccountManager().listAccounts(BasicAuthTest.agentId, null, 0, 0);
		assertTrue(accounts.size()>0);
	}
	
	@Test
	public void C5_synchAccount() throws ClientException, ResponseException{
		Synchronization synch = ApiClient.getAccountManager().synchronizeAccount(BasicAuthTest.customerAccountId, false);
		assertTrue(synch != null);
	}
	
	@Test
	public void C6_FollowupAccountSynchronisation()  throws ClientException, ResponseException, InterruptedException{
		Accounts accountManager = ApiClient.getAccountManager();
		Account account = accountManager.getAccount(BasicAuthTest.customerAccountId);
		assertNotNull(account);
		
		
		Synchronization lastSynchronization = accountManager.getLastSynchronizationOfAccount(account.getCustomerAccountId());
		assertNotNull(lastSynchronization);
		while(lastSynchronization.getSynchronizationState() == SynchronizationState.CREATED ||
				lastSynchronization.getSynchronizationState() == SynchronizationState.RUNNING ||
				lastSynchronization.getSynchronizationState() == SynchronizationState.TO_DELIVER ||
				lastSynchronization.getSynchronizationState() == SynchronizationState.DELIVERING){
			Thread.sleep(5000);

			lastSynchronization = accountManager.getLastSynchronizationOfAccount(account.getCustomerAccountId());
		}
	}
	
	@Test
	public void D1_GetDocuments() throws ClientException, ResponseException, UnsupportedEncodingException {
		Documents documentManager = ApiClient.getDocumentManager();
		List<Document> documents = documentManager.searchDocuments(BasicAuthTest.customerAccountId, BasicAuthTest.customerUserId, false, true);
		assertFalse(documents.isEmpty());
	}
	
	@Test
	public void D2_DocumentAcknowledgement() throws UnsupportedEncodingException, ClientException, ResponseException {
		Documents documentManager = ApiClient.getDocumentManager();
		List<Document> documents = documentManager.searchDocuments(BasicAuthTest.customerAccountId, BasicAuthTest.customerUserId, false, false);
		assertFalse(documents.isEmpty());
		
		Document firstDocument = documents.get(0);
		documentManager.acknowledgeDocumentDelivery(firstDocument.getId(),true, false);
		
		List<Document> documentsAfterAck = documentManager.searchDocuments(BasicAuthTest.customerAccountId, BasicAuthTest.customerUserId, true, false);
		
		for(Document document : documentsAfterAck) {
			assertFalse(document.getId() == firstDocument.getId());
		}
	}
	
	@Test
	public void D3_AccountAcknowledgement() throws UnsupportedEncodingException, ClientException, ResponseException {
		Documents documentManager = ApiClient.getDocumentManager();
		List<Document> documents = documentManager.searchDocuments(BasicAuthTest.customerAccountId, BasicAuthTest.customerUserId, true, false);

		long[] documentIds = new long[documents.size()];
		for(int i = 0; i < documents.size(); i++) {
			documentIds[i] = documents.get(i).getId();
		}
		
		Synchronizations synchManager = ApiClient.getSynchronizationManager();
		synchManager.acknowledgeSynchronizationDelivery(BasicAuthTest.customerAccountId, documentIds, new long[] {});
		
	}
		
	@Test
	public void Z1_deleteAccount()  throws ClientException, ResponseException{
		ApiClient.getAccountManager().deleteAccount(BasicAuthTest.customerAccountId);
	}
}