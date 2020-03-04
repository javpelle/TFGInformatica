package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class ZXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateZ_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with X gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".z(";
	}

	@Override
	public String getMutantOperator() {
		return ".x(";
	}

}