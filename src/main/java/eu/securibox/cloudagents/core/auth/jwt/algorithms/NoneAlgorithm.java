package eu.securibox.cloudagents.core.auth.jwt.algorithms;

import org.apache.commons.codec.binary.Base64;

import eu.securibox.cloudagents.core.auth.jwt.DecodedJWT;
import eu.securibox.cloudagents.core.auth.jwt.exceptions.SignatureGenerationException;
import eu.securibox.cloudagents.core.auth.jwt.exceptions.SignatureVerificationException;

class NoneAlgorithm extends Algorithm {

    NoneAlgorithm() {
        super("none", "none");
    }

    @Override
    public void verify(DecodedJWT jwt) throws SignatureVerificationException {
        byte[] signatureBytes = Base64.decodeBase64(jwt.getSignature());
        if (signatureBytes.length > 0) {
            throw new SignatureVerificationException(this);
        }
    }

    @Override
    public byte[] sign(byte[] contentBytes) throws SignatureGenerationException {
        return new byte[0];
    }
}