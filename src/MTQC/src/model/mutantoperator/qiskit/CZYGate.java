package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CZYGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCZ_GateCY";
	}

	@Override
	public String getDescription() {
		return "Replace CZ gate with CY gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cz(";
	}

	@Override
	public String getMutantOperator() {
		return ".cy(";
	}

}