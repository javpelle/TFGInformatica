package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class TSdgGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateT_GateSdg";
	}

	@Override
	public String getDescription() {
		return "Replace T gate with Sdg gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".t(";
	}

	@Override
	public String getMutantOperator() {
		return ".sdg(";
	}

}