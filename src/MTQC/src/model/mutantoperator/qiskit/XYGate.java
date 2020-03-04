package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class XYGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateX_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace X gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".x(";
	}

	@Override
	public String getMutantOperator() {
		return ".y(";
	}

}