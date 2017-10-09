package eu.securibox.cloudagents.core.auth.jwt.exceptions;


public class JWTDecodeException extends JWTVerificationException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8669373985193346150L;

	public JWTDecodeException(String message) {
        this(message, null);
    }

    public JWTDecodeException(String message, Throwable cause) {
        super(message, cause);
    }
}