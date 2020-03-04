package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CHYGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCH_GateCY";
	}

	@Override
	public String getDescription() {
		return "Replace CH gate with CY gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ch(";
	}

	@Override
	public String getMutantOperator() {
		return ".cy(";
	}

}