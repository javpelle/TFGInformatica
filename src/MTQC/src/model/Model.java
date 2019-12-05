package model;

public class Model implements Observable<Observer> {
	
	/**
	 * Observer.
	 */
	private Observer observer;
	
	
	
	/**
	 * Notifies the observer that some error occurred, and throw an exception
	 * as well.
	 */
	private void notifyError(RuntimeException e) {
		String msg = e.getLocalizedMessage();
		observer.onError(msg);
		
		throw e;
	}

	@Override
	public void addObserver(Observer o) {
		observer = o;		
	}

	@Override
	public void removeObserver(Observer o) {
		observer = null;		
	}

}
