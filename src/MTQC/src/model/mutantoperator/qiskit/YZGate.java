package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class YZGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateY_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".y(";
	}

	@Override
	public String getMutantOperator() {
		return ".z(";
	}

}