package eu.securibox.cloudagents.core.auth.jwt.parts;


import java.util.Date;
import java.util.List;
import java.util.Map;

import eu.securibox.cloudagents.core.auth.jwt.exceptions.JWTDecodeException;

/**
 * The {@link NullClaim} class is a Claim implementation that returns null when any of it's methods it's called.
 */
public class NullClaim implements Claim {
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public Boolean asBoolean() {
        return null;
    }

    @Override
    public Integer asInt() {
        return null;
    }

    @Override
    public Long asLong() {
        return null;
    }

    @Override
    public Double asDouble() {
        return null;
    }

    @Override
    public String asString() {
        return null;
    }

    @Override
    public Date asDate() {
        return null;
    }

    @Override
    public <T> T[] asArray(Class<T> tClazz) throws JWTDecodeException {
        return null;
    }

    @Override
    public <T> List<T> asList(Class<T> tClazz) throws JWTDecodeException {
        return null;
    }

    @Override
    public Map<String, Object> asMap() throws JWTDecodeException {
        return null;
    }

    @Override
    public <T> T as(Class<T> tClazz) throws JWTDecodeException {
        return null;
    }
}
