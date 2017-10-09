package eu.securibox.cloudagents.core.auth.jwt.parts;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import eu.securibox.cloudagents.core.auth.jwt.exceptions.JWTDecodeException;

import java.io.IOException;
import java.util.Map;


public class HeaderDeserializer extends StdDeserializer<Header> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2204771885050775887L;

	public HeaderDeserializer() {
        this(null);
    }

    private HeaderDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Header deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Map<String, JsonNode> tree = p.getCodec().readValue(p, new TypeReference<Map<String, JsonNode>>() {
        });
        if (tree == null) {
            throw new JWTDecodeException("Parsing the Header's JSON resulted on a Null map");
        }

        String algorithm = getString(tree, PublicClaims.ALGORITHM);
        String type = getString(tree, PublicClaims.TYPE);
        String contentType = getString(tree, PublicClaims.CONTENT_TYPE);
        String keyId = getString(tree, PublicClaims.KEY_ID);
        return new Header(algorithm, type, contentType, keyId, tree);
    }

    String getString(Map<String, JsonNode> tree, String claimName) {
        JsonNode node = tree.get(claimName);
        if (node == null || node.isNull()) {
            return null;
        }
        return node.asText(null);
    }
}
