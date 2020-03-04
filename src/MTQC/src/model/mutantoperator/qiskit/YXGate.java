package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class YXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateY_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with X gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".y(";
	}

	@Override
	public String getMutantOperator() {
		return ".x(";
	}

}