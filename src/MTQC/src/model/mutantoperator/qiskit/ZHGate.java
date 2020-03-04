package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class ZHGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateZ_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with H gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".z(";
	}

	@Override
	public String getMutantOperator() {
		return ".h(";
	}

}