package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class ZSdgGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateZ_GateSdg";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with Sdg gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".z(";
	}

	@Override
	public String getMutantOperator() {
		return ".sdg(";
	}

}