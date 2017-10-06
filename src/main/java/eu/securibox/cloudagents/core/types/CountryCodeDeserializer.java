package eu.securibox.cloudagents.core.types;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


public class CountryCodeDeserializer extends JsonDeserializer<CountryCode> {

	@Override
	public CountryCode deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		String text = p.getText().trim();
		return CountryCode.deserialize(text);

	}
}
