package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class ZTGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateZ_GateT";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with T gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".z(";
	}

	@Override
	public String getMutantOperator() {
		return ".t(";
	}

}