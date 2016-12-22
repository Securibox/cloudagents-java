package core.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientException.
 */
public class ClientException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8193885700242302897L;
	
	/**
	 * Instantiates a new client exception.
	 */
	public ClientException(){		
		super();
	}
	
	/**
	 * Instantiates a new client exception.
	 *
	 * @param message the message
	 */
	public ClientException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new client exception.
	 *
	 * @param e the e
	 */
	public ClientException(Exception e) {
		super(e);
	}
}
