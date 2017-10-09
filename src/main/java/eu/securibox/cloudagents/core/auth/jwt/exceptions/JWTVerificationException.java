package eu.securibox.cloudagents.core.auth.jwt.exceptions;

public class JWTVerificationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1610313761750083089L;

	public JWTVerificationException(String message) {
        this(message, null);
    }

    public JWTVerificationException(String message, Throwable cause) {
        super(message, cause);
    }
}