package model;

import model.mutantoperator.MutantOperator;
import model.mutantoperator.qiskit.AndOr;
import model.mutantoperator.qiskit.OrAnd;

public class Model implements Observable<Observer> {

	/**
	 * Observer.
	 */
	private Observer observer;

	private boolean qiskit;

	private MutantOperator[] qiskitOperators = { new AndOr(), new OrAnd() };

	private MutantOperator[] qsharpOperators = {};

	public Model() {
		qiskit = true;
	}

	/**
	 * Notifies the observer that some error occurred, and throw an exception as
	 * well.
	 */
	private void notifyError(RuntimeException e) {
		String msg = e.getLocalizedMessage();
		observer.onError(msg);

		throw e;
	}

	private void notifyLanguageChange() {
		if (qiskit) {
			observer.updateMutantOperators(qiskitOperators);
		} else {
			observer.updateMutantOperators(qsharpOperators);
		}
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
