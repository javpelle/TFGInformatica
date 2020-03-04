package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class ZYGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateZ_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".z(";
	}

	@Override
	public String getMutantOperator() {
		return ".y(";
	}

}