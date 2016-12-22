package core.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;

import core.Response;

public class HttpResponse implements Response {

	String body = null;
	String responseMessage = null;
	int statusCode;

	public HttpResponse(org.apache.http.client.fluent.Response response) throws IOException {
		if (response == null) {
			throw new IOException("No Response object was returned by the client.");
		}		
		org.apache.http.HttpResponse resp = response.returnResponse();
		StatusLine statusLine = resp.getStatusLine();
		this.statusCode = statusLine.getStatusCode();
		this.responseMessage = statusLine.getReasonPhrase();
		this.body = HttpResponse.readEntity(resp.getEntity());
	}

	private static String readEntity(HttpEntity entity) throws IOException {
		StringBuilder out = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			reader.close();
		} finally {
			EntityUtils.consume(entity);
		}
		return out.toString();
	}

	public String getBody() {
		return this.body;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public String getResponseMessage() {
		return this.responseMessage;
	}

}
