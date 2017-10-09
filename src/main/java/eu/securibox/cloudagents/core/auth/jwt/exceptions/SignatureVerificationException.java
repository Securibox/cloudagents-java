package eu.securibox.cloudagents.core.auth.jwt.exceptions;

import eu.securibox.cloudagents.core.auth.jwt.algorithms.Algorithm;

public class SignatureVerificationException extends JWTVerificationException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3937941446524338297L;

	public SignatureVerificationException(Algorithm algorithm) {
        this(algorithm, null);
    }

    public SignatureVerificationException(Algorithm algorithm, Throwable cause) {
        super("The Token's Signature resulted invalid when verified using the Algorithm: " + algorithm, cause);
    }
}