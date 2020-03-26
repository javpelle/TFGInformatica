package exception;

public class NullStringException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullStringException(String str) {
		super("Chose a " + str + ".\n");
	}

}