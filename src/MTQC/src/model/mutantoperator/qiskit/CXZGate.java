package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CXZGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCX_GateCZ";
	}

	@Override
	public String getDescription() {
		return "Replace CX gate with CZ gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cx(";
	}

	@Override
	public String getMutantOperator() {
		return ".cz(";
	}

}