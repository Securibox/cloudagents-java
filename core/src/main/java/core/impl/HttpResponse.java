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
