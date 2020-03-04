package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class RZYGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateRZ_GateRY";
	}

	@Override
	public String getDescription() {
		return "Replace RZ gate with RY gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".rz(";
	}

	@Override
	public String getMutantOperator() {
		return ".ry(";
	}

}