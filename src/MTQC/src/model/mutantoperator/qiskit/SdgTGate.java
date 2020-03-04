package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class SdgTGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateSdg_GateT";
	}

	@Override
	public String getDescription() {
		return "Replace Sdg gate with T gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".sdg(";
	}

	@Override
	public String getMutantOperator() {
		return ".t(";
	}

}