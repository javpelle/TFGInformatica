package model;

import java.io.File;
import java.util.ArrayList;

import model.mutantoperator.MutantOperator;
import model.mutantoperator.qiskit.AndOr;
import model.mutantoperator.qiskit.OrAnd;
import model.mutantoperator.qsharp.GateHX;
import model.mutantoperator.qsharp.GateHY;

public class Model implements Observable<Observer> {

	/**
	 * Observer.
	 */
	private Observer observer;

	private boolean qiskit;

	private String path;

	private MutantOperator[] qiskitOperators = { new AndOr(), new OrAnd() };

	private MutantOperator[] qsharpOperators = { new GateHX(), new GateHY() };

	public Model() {
		qiskit = false;
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

	public void notifyLanguageChange() {
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

	public void start() {
		updatePath(System.getProperty("user.dir"));
		updateMutantOperators(false);
	}

	public void updateMutantOperators(boolean qiskit) {
		this.qiskit = qiskit;
		if (qiskit) {
			observer.updateMutantOperators(qiskitOperators);
		} else {
			observer.updateMutantOperators(qsharpOperators);
		}
	}

	public void updatePath(String path) {
		this.path = path;
		ArrayList<String> files = new ArrayList<String>();
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files.add(listOfFiles[i].getName());
			}
		}
		observer.updatePath(files);
	}

}
