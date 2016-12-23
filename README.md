# SCA documents api for java


## Basic Authentication 

Sample Code:

```java
import org.junit.BeforeClass;
import org.junit.Test;

import api.documents.beans.Agent;
import api.documents.managers.impl.ApiClient;
import core.SecurityConfiguration;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;
import core.impl.SSLConfiguration;
import java.util.List;

public class AgentsBasicAuth {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SecurityConfiguration systConfig = SSLConfiguration.Basic(null, "userName", "password");
		ApiClient.ConfigureClient("https://sca-{clientName}.securibox.eu/api/v1",systConfig);
	}
	@Test
	public void listAgentsTest() throws ClientException, ResponseException {
		List<Agent> agents = ApiClient.getAgentManager().listAgents("fr-FR");
		System.out.println(agents.get(0).getName());
	}
}
    
```

## Certificate Authentication 

Sample Code:


```java
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import api.documents.beans.Agent;
import api.documents.managers.impl.ApiClient;
import core.SecurityConfiguration;
import core.TrustStore;
import core.exceptions.ClientException;
import core.exceptions.ResponseException;
import core.impl.HttpTrustStore;
import core.impl.SSLConfiguration;

public class AgentsCertAuth {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SecurityConfiguration systConfig = SSLConfiguration.ClientCertificate(null, "src/resources/{certificate-name}.p12", "{certificate-password}", "{certificate-private-key-password}");
		ApiClient.ConfigureClient("https://sca-{clientName}.securibox.eu/api/v1",systConfig);
	}
	@Test
	public void listAgentsTest() throws ClientException, ResponseException {
		List<Agent> agents = ApiClient.getAgentManager().listAgents("fr-FR");
		System.out.println(agents.get(0).getName());
	}
}
```
