package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CYHGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCY_GateCH";
	}

	@Override
	public String getDescription() {
		return "Replace CY gate with CH gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cy(";
	}

	@Override
	public String getMutantOperator() {
		return ".ch(";
	}

}