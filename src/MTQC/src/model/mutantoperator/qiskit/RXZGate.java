package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class RXZGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateRX_GateRZ";
	}

	@Override
	public String getDescription() {
		return "Replace RX gate with RZ gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".rx(";
	}

	@Override
	public String getMutantOperator() {
		return ".rz(";
	}

}