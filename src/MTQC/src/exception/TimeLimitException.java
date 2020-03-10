package exception;

public class TimeLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeLimitException() {
		super("Time limit must be greater than zero.\n");
	}

}
