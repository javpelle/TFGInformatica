package exception;

/**
 * 
 * @author Javier & Luis	
 *
 */
public class TimeLimitException extends Exception {

	/**
	 * Unique serial version identifier
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Empty Constructor
	 */
	public TimeLimitException() {
		super("Time limit must be greater than zero.\n");
	}

}
