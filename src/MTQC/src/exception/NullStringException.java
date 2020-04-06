package exception;

/**
 * 
 * @author Javier & Luis
 *
 */
public class NullStringException extends Exception {

	/**
	 * Unique serial version identifier
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for this exeption
	 * @param str Name of the non selected field
	 */
	public NullStringException(String str) {
		super("Chose a " + str + ".\n");
	}

}