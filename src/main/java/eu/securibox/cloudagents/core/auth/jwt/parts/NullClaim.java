package eu.securibox.cloudagents.core.auth.jwt.parts;


import java.util.Date;
import java.util.List;
import java.util.Map;

import eu.securibox.cloudagents.core.auth.jwt.exceptions.JWTDecodeException;

/**
 * The {@link NullClaim} class is a Claim implementation that returns null when any of it's methods it's called.
 */
public class NullClaim implements Claim {
    public boolean isNull() {
        return true;
    }

    public Boolean asBoolean() {
        return null;
    }

    public Integer asInt() {
        return null;
    }

    public Long asLong() {
        return null;
    }

    public Double asDouble() {
        return null;
    }

    public String asString() {
        return null;
    }

    public Date asDate() {
        return null;
    }

    public <T> T[] asArray(Class<T> tClazz) throws JWTDecodeException {
        return null;
    }

    public <T> List<T> asList(Class<T> tClazz) throws JWTDecodeException {
        return null;
    }

    public Map<String, Object> asMap() throws JWTDecodeException {
        return null;
    }

    public <T> T as(Class<T> tClazz) throws JWTDecodeException {
        return null;
    }
}
