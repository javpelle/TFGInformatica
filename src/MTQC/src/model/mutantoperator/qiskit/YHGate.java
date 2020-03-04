package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class YHGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateY_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with H gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".y(";
	}

	@Override
	public String getMutantOperator() {
		return ".h(";
	}

}