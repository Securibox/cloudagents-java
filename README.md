# cloudagents-java
A Java client library for the Securibox Cloud Agents API

## Authentication
In order to secure the Securibox Cloud Agents API, three mechanisms have been implemented.
Here is a brief overview of the three mechanisms as well as code snippets to help you integrate the correct mechanism in order to call the APIs.

### Basic API Authentication w/ TLS
Basic API authentication is the easiest of the three to implement offering the lowest security options of the common protocols.
This mechanism is usually advised for testing purposes in order to test the APIs and only requires Securibox to provide a username and password.

```java
SecurityConfiguration systConfig = SSLConfiguration.Basic(null, "userName", "password");
ApiClient.ConfigureClient("https://sca-{clientName}.securibox.eu/api/v1",systConfig);
```

### SSL Client Certificate Authentication 
The SSL client certification is a mechanism allowing your application to authenticate itself with the Securibox Cloud Agents (SCA) servers. In this case, your application will send its SSL certificate after verifing the SCA server identity. Then, the client and server use both certificates to generate a unique key used to sign requests sent between them.

This kind of authentication is implemented when the customer call your servers that will then call the Securibox Cloud Agents API.

In order to use this type of authentication, Securibox will provide a PKCS#12 file (.p12 or .pfx) containing a password protected private key and a X.509 certificate.

```java
SecurityConfiguration systConfig = SSLConfiguration.ClientCertificate(null, "src/resources/{certificate-name}.p12", "{certificate-password}", "{certificate-private-key-password}");
ApiClient.ConfigureClient("https://sca-{clientName}.securibox.eu/api/v1",systConfig);
```
### JSON Web Token Authentication
[JSON Web Token (JWT)](https://jwt.io) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed. JWTs can be signed using a public/private key pair using RS256 (RSA PKCS#1 signature with SHA-256).

This kind of authentication is implemented when the customer calls directly the Securibox Cloud Agents API together with [cross-origin resource sharing (CORS)](https://en.wikipedia.org/wiki/Cross-origin_resource_sharing).

In order to use this type of authentication, Securibox will provide a PKCS#8 public and password protected private key in PEM file (.pem).
```java
SecurityConfiguration securityConfiguration = SSLConfiguration.JWT(null, "publicKey.pem","privateKey.pem",  "PrivateKeyPassword");
ApiClient.ConfigureClient("https://sca-{clientName}.securibox.eu/api/v1", securityConfiguration);
```
## Getting started
The following code is the minimum code needed to configure an account and launch a synchronization:
```java
//Setting up the client with basic authentication
SecurityConfiguration systConfig = SSLConfiguration.Basic(null, "basic_username", "basic_password");
ApiClient.ConfigureClient("https://sca-{clientName}.securibox.eu/api/v1", systConfig);

//Creating an account
Account account = new Account();
account.setAgentId("93fddb673a2d4fb49406f21a5937dc90");
account.setCustomerUserId("User_Id_109");
account.setCustomerAccountId("d5df848e31894ce98c06a3aaef91877a");
account.setMode(AccountMode.Enabled);
account.setName("Agent Test name");
Credential userName = new Credential(0, "Credential 1");
Credential birthName = new Credential(1, "Credential 2");
Credential password = new Credential(2, "Credential 3");
account.getCredentials().add(userName);
account.getCredentials().add(birthName);
account.getCredentials().add(password);
Account returnedAccount = ApiClient.getAccountManager().createAccount(account, false);

//Synchronizing an account
Synchronization synch = ApiClient.getAccountManager().synchronizeAccount("d5df848e31894ce98c06a3aaef91877a", false);

//Polling the synchronization status to see when the synchronization is completed
Account account = ApiClient.getAccountManager().getAccount("d5df848e31894ce98c06a3aaef91877a");
String lastSynchState = account.getLastSynchronizationState();
while(lastSynchState.compareTo("Completed") != 0){
	Thread.sleep(5000);
    account = ApiClient.getAccountManager().getAccount("d5df848e31894ce98c06a3aaef91877a");
}

//Let's get the newly documents
List<Document> documents = ApiClient.getAccountManager.listDocumentsByAccount("d5df848e31894ce98c06a3aaef91877a", true, true);

//Acknowledge the last synchronization
ApiClient.getSynchronizationManager().acknowledgeSynchronizationDelivery("d5df848e31894ce98c06a3aaef91877a", new long[]{}, new long[]{});

//Update an account
Account account = ApiClient.getAccountManager().getAccount("d5df848e31894ce98c06a3aaef91877a");
account.setName("New Name");
Account returnedAccount = ApiClient.getAccountManager().updateAccount(account);

//Delete an account
ApiClient.getAccountManager().deleteAccount("d5df848e31894ce98c06a3aaef91877a");
```

## Webhooks
The result of each synchronization is posted in a webhook that needs to be setup in the API client application.
Once a synchronization is done, an HTTP POST request will be made to the wehbhook endpoint to send the result.
If an authentication is required, Securibox Cloud Agents is able to authenticate itself through basic authentication, SSL client certificate and JWT.

Some examples of the JSON objects sent to the webhooks can be seen the [src\test\resources folder](https://github.com/Securibox/cloudagents-java/tree/master/src/test/resources).

The following code deserializes the JSON synchronization object:
```java
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.securibox.cloudagents.api.banks.beans.Synchronization;

ObjectMapper mapper = new ObjectMapper();
Synchronization synchronization = mapper.readValue(jsonSynchResult, Synchronization.class);
```
