package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CXHGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCX_GateCH";
	}

	@Override
	public String getDescription() {
		return "Replace CX gate with CH gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cx(";
	}

	@Override
	public String getMutantOperator() {
		return ".ch(";
	}

}