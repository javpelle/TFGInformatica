package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CXYGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCX_GateCY";
	}

	@Override
	public String getDescription() {
		return "Replace CX gate with CY gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cx(";
	}

	@Override
	public String getMutantOperator() {
		return ".cy(";
	}

}