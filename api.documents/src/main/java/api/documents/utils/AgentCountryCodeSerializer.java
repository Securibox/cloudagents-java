package api.documents.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import api.documents.beans.AgentCountryCode;

public class AgentCountryCodeSerializer extends JsonSerializer<AgentCountryCode> {

	@Override
	public void serialize(AgentCountryCode value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeNumber(value.getCode());
	}

}
