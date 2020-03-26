package exception;

public class EmptyListException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyListException(String list) {
		super(list + " can not be an empty list.\n");
	}

}