package eu.securibox.cloudagents.core.auth.jwt.exceptions;

import eu.securibox.cloudagents.core.auth.jwt.algorithms.AlgorithmRSA;

public class SignatureGenerationException extends JWTCreationException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8820775298090618065L;

	public SignatureGenerationException(AlgorithmRSA algorithm, Throwable cause) {
        super("The Token's Signature couldn't be generated when signing using the Algorithm: " + algorithm, cause);
    }
}