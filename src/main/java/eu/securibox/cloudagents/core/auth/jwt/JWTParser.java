package eu.securibox.cloudagents.core.auth.jwt;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.annotation.JsonInclude;

import eu.securibox.cloudagents.core.auth.jwt.exceptions.JWTDecodeException;
import eu.securibox.cloudagents.core.auth.jwt.parts.Header;
import eu.securibox.cloudagents.core.auth.jwt.parts.HeaderDeserializer;
import eu.securibox.cloudagents.core.auth.jwt.parts.Payload;
import eu.securibox.cloudagents.core.auth.jwt.parts.PayloadDeserializer;

public class JWTParser {
    private ObjectMapper mapper;

    public JWTParser() {
        this(getDefaultObjectMapper());
    }

    JWTParser(ObjectMapper mapper) {
        addDeserializers(mapper);
        this.mapper = mapper;
    }

    
    public Payload parsePayload(String json) throws JWTDecodeException {
        return convertFromJSON(json, Payload.class);
    }

    
    public Header parseHeader(String json) throws JWTDecodeException {
        return convertFromJSON(json, Header.class);
    }
    
    private void addDeserializers(ObjectMapper mapper) {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Payload.class, new PayloadDeserializer());
        module.addDeserializer(Header.class, new HeaderDeserializer());
        mapper.registerModule(module);
    }

    static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return mapper;
    }

    <T> T convertFromJSON(String json, Class<T> tClazz) throws JWTDecodeException {
        if (json == null) {
            throw exceptionForInvalidJson(null);
        }
        try {
            return mapper.readValue(json, tClazz);
        } catch (IOException e) {
            throw exceptionForInvalidJson(json);
        }
    }

    private JWTDecodeException exceptionForInvalidJson(String json) {
        return new JWTDecodeException(String.format("The string '%s' doesn't have a valid JSON format.", json));
    }
}