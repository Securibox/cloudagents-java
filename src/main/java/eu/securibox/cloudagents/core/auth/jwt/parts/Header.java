package eu.securibox.cloudagents.core.auth.jwt.parts;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import static eu.securibox.cloudagents.core.auth.jwt.parts.JsonNodeClaim.extractClaim;

public class Header {
    private final String algorithm;
    private final String type;
    private final String contentType;
    private final String keyId;
    private final Map<String, JsonNode> tree;
    
    Header(String algorithm, String type, String contentType, String keyId, Map<String, JsonNode> tree) {
        this.algorithm = algorithm;
        this.type = type;
        this.contentType = contentType;
        this.keyId = keyId;
        this.tree = Collections.unmodifiableMap(tree == null ? new HashMap<String, JsonNode>() : tree);
    }
    
    Map<String, JsonNode> getTree() {
        return tree;
    }
    
    public String getAlgorithm() {
        return algorithm;
    }

    public String getType() {
        return type;
    }

    public String getContentType() {
        return contentType;
    }

    public String getKeyId() {
        return keyId;
    }

    public Claim getHeaderClaim(String name) {
        return extractClaim(name, tree);
    }    

}
