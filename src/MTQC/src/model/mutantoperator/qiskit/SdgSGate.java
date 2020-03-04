package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class SdgSGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateSdg_GateS";
	}

	@Override
	public String getDescription() {
		return "Replace Sdg gate with S gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".sdg(";
	}

	@Override
	public String getMutantOperator() {
		return ".s(";
	}

}