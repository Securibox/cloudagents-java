package eu.securibox.cloudagents.api.banks;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.securibox.cloudagents.api.banks.beans.*;
import eu.securibox.cloudagents.core.SecurityConfiguration;
import eu.securibox.cloudagents.core.configuration.SSLConfiguration;
import eu.securibox.cloudagents.core.exceptions.*;



public class BasicAuthTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SecurityConfiguration systConfig = SSLConfiguration.Basic(null, "basic_username", "basic_password");
		ApiClient.ConfigureClient("https://sca-multitenant.securibox.eu/api/bankv1/",systConfig);
	}

	@Test
	public void listBanks() throws ClientException, ResponseException {
		List<Bank> banks = ApiClient.getBankManager().ListBanks();
		assertTrue(banks.size()>0);
	}
	
	@Test
	public void createAccount() throws ClientException{
		Account account = new Account(); //Create account for BforBank
		account.setBankId("381c9ea540c14519b88ee345bb691a14");
		account.setCustomerUserId("User_Id_109");
		account.setCustomerAccountId("d5df848e31894ce98c06a3aaef91877a");
		account.setMode(AccountMode.Enabled);
		account.setName("BforBank Test name");
		
		Credential userName = new Credential(0, "Credential 1");
		Credential birthName = new Credential(1, "Credential 2");
		Credential password = new Credential(2, "Credential 3");
		
		
		account.getCredentials().add(userName);
		account.getCredentials().add(birthName);
		account.getCredentials().add(password);
		Account returnedAccount = null;
		try{
			returnedAccount = ApiClient.getAccountManager().createAccount(account, false);
		}catch(ResponseException ex){
			ex.toString();
		}
		assertTrue(returnedAccount != null);
	}
	
	@Test
	public void synchAccount() throws ClientException, ResponseException{
		Synchronization synch = ApiClient.getAccountManager().synchronizeAccount("d5df848e31894ce98c06a3aaef91877a", false);
		assertTrue(synch != null);
	}
	
	@Test
	public void getAccounts()  throws ClientException, ResponseException, InterruptedException{
		Account account = ApiClient.getAccountManager().getAccount("d5df848e31894ce98c06a3aaef91877a");
		String lastSynchState = account.getLastSynchronizationState();
		while(lastSynchState.compareTo("Completed") != 0){
			Thread.sleep(5000);
			account = ApiClient.getAccountManager().getAccount("d5df848e31894ce98c06a3aaef91877a");
		}
		List<BankAccount> bankAccounts = ApiClient.getBankAccountManager().ListBankAccountsByAccount("d5df848e31894ce98c06a3aaef91877a");
		assertTrue(bankAccounts.size()>0);
	}
	

	@Test
	public void updateAccount() throws ClientException, ResponseException{
		Account account = ApiClient.getAccountManager().getAccount("d5df848e31894ce98c06a3aaef91877a");
		account.setName("New Name");
		
		Account returnedAccount = ApiClient.getAccountManager().updateAccount(account);
		assertTrue(returnedAccount != null);
	}
	
	@Test
	public void deleteAccount()  throws ClientException, ResponseException{
		ApiClient.getAccountManager().deleteAccount("d5df848e31894ce98c06a3aaef91877a");
	}	

}
