package model;

/**
 * An observer for UI. Will be notified when model update his state
 */
public interface Observer {
	
	/**
	 * Notifies that something went wrong.
	 * @param msg
	 *            An error message.
	 */
	public void onError(String msg);

}
