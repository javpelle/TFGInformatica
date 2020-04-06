package exception;

/**
 * 
 * @author Javier & Luis
 *
 */
public class EmptyListException extends Exception {

	/**
	 * Unique serial version identifier
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for this exception
	 * 
	 * @param list Name of the empty list
	 */
	public EmptyListException(String list) {
		super(list + " can not be an empty list.\n");
	}

}