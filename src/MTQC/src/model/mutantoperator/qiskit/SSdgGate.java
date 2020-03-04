package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class SSdgGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateS_GateSdg";
	}

	@Override
	public String getDescription() {
		return "Replace S gate with Sdg gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".s(";
	}

	@Override
	public String getMutantOperator() {
		return ".sdg(";
	}

}