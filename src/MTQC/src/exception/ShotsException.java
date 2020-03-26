package exception;

public class ShotsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShotsException() {
		super("Shots must be greater than zero.\n");
	}

}