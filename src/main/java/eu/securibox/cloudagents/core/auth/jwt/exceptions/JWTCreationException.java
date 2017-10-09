package eu.securibox.cloudagents.core.auth.jwt.exceptions;

public class JWTCreationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7876351686150109158L;

	public JWTCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}