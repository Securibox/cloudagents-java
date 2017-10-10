package eu.securibox.cloudagents.api.banks;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import eu.securibox.cloudagents.api.banks.beans.Synchronization;
import eu.securibox.cloudagents.core.exceptions.ClientException;
import eu.securibox.cloudagents.core.exceptions.ResponseException;

public class Webhook {
	@Test
	public void HandleResponse() throws ClientException, ResponseException, IOException {
		String jsonSynchResult = FileUtils.readFileToString(new File("src/test/resources/Transactions.json"), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		Synchronization synchronization = mapper.readValue(jsonSynchResult, Synchronization.class);
		
		System.out.println("identifier:" + synchronization.getIdentifier());
		System.out.println("customerAccountId:" + synchronization.getCustomerAccountId());
		System.out.println("customerUserId:" + synchronization.getCustomerUserId());
		System.out.println("state:" + synchronization.getState());

	}
}
