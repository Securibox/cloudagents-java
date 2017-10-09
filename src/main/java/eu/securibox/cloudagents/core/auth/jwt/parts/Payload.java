package eu.securibox.cloudagents.core.auth.jwt.parts;

import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import static eu.securibox.cloudagents.core.auth.jwt.parts.JsonNodeClaim.extractClaim;

public class Payload {
	private final String issuer;
    private final String subject;
    private final List<String> audience;
    private final Date expiresAt;
    private final Date notBefore;
    private final Date issuedAt;
    private final String jwtId;
    private final Map<String, JsonNode> tree;

    Payload(String issuer, String subject, List<String> audience, Date expiresAt, Date notBefore, Date issuedAt, String jwtId, Map<String, JsonNode> tree) {
        this.issuer = issuer;
        this.subject = subject;
        this.audience = audience;
        this.expiresAt = expiresAt;
        this.notBefore = notBefore;
        this.issuedAt = issuedAt;
        this.jwtId = jwtId;
        this.tree = Collections.unmodifiableMap(tree == null ? new HashMap<String, JsonNode>() : tree);
    }

    Map<String, JsonNode> getTree() {
        return tree;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getSubject() {
        return subject;
    }

    public List<String> getAudience() {
        return audience;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public Date getNotBefore() {
        return notBefore;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public String getId() {
        return jwtId;
    }

    public Claim getClaim(String name) {
        return extractClaim(name, tree);
    }

    public Map<String, Claim> getClaims() {
        Map<String, Claim> claims = new HashMap<>();
        for (String name : tree.keySet()) {
            claims.put(name, extractClaim(name, tree));
        }
        return Collections.unmodifiableMap(claims);
    }
}