package api.documents.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import api.documents.beans.AgentCountryCode;

public class AgentCountryCodeDeserializer extends JsonDeserializer<AgentCountryCode> {

	@Override
	public AgentCountryCode deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		String text = p.getText().trim();
		return AgentCountryCode.deserialize(text);

	}
}
