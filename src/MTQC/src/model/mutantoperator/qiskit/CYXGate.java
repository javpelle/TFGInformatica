package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CYXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCY_GateCX";
	}

	@Override
	public String getDescription() {
		return "Replace CY gate with CX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cy(";
	}

	@Override
	public String getMutantOperator() {
		return ".cx(";
	}

}