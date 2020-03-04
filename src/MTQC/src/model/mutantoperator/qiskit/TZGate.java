package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class TZGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateT_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace T gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".t(";
	}

	@Override
	public String getMutantOperator() {
		return ".z(";
	}

}