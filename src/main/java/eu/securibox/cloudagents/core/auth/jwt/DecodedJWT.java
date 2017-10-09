package eu.securibox.cloudagents.core.auth.jwt;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import eu.securibox.cloudagents.core.auth.jwt.exceptions.JWTDecodeException;
import eu.securibox.cloudagents.core.auth.jwt.parts.Claim;
import eu.securibox.cloudagents.core.auth.jwt.parts.Header;
import eu.securibox.cloudagents.core.auth.jwt.parts.Payload;

public class DecodedJWT {

    private final String[] parts;
    private final Header header;
    private final Payload payload;

    DecodedJWT(String jwt) throws JWTDecodeException {
        parts = TokenUtils.splitToken(jwt);
        final JWTParser converter = new JWTParser();
        String headerJson;
        String payloadJson;
        try {
            headerJson = StringUtils.newStringUtf8(Base64.decodeBase64(parts[0]));
            payloadJson = StringUtils.newStringUtf8(Base64.decodeBase64(parts[1]));
        } catch (NullPointerException e) {
            throw new JWTDecodeException("The UTF-8 Charset isn't initialized.", e);
        }
        header = converter.parseHeader(headerJson);
        payload = converter.parsePayload(payloadJson);
    }

    public String getAlgorithm() {
        return header.getAlgorithm();
    }

    public String getType() {
        return header.getType();
    }

    public String getContentType() {
        return header.getContentType();
    }

    public String getKeyId() {
        return header.getKeyId();
    }

    public Claim getHeaderClaim(String name) {
        return header.getHeaderClaim(name);
    }

    public String getIssuer() {
        return payload.getIssuer();
    }

    public String getSubject() {
        return payload.getSubject();
    }

    public List<String> getAudience() {
        return payload.getAudience();
    }

    public Date getExpiresAt() {
        return payload.getExpiresAt();
    }

    public Date getNotBefore() {
        return payload.getNotBefore();
    }

    public Date getIssuedAt() {
        return payload.getIssuedAt();
    }

    public String getId() {
        return payload.getId();
    }

    public Claim getClaim(String name) {
        return payload.getClaim(name);
    }

    public Map<String, Claim> getClaims() {
        return payload.getClaims();
    }

    public String getHeader() {
        return parts[0];
    }

    public String getPayload() {
        return parts[1];
    }

    public String getSignature() {
        return parts[2];
    }

    public String getToken() {
        return String.format("%s.%s.%s", parts[0], parts[1], parts[2]);
    }    
}
