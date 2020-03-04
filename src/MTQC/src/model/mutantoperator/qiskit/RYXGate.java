package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class RYXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateRY_GateRX";
	}

	@Override
	public String getDescription() {
		return "Replace RY gate with RX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ry(";
	}

	@Override
	public String getMutantOperator() {
		return ".rx(";
	}

}