package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public abstract class QiskitGate extends MutantOperator {

	@Override
	public boolean checkRegEx(String matcher) {
		return true;
	}

}