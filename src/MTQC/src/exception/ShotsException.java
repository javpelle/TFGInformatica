package exception;

/**
 * 
 * @author Javier & Luis
 *
 */
public class ShotsException extends Exception {

	/**
	 * Unique serial version identifier
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Empty constructor
	 */
	public ShotsException() {
		super("Shots must be greater than zero.\n");
	}

}