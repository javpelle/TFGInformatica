package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class RZXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateRZ_GateRX";
	}

	@Override
	public String getDescription() {
		return "Replace RZ gate with RX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".rz(";
	}

	@Override
	public String getMutantOperator() {
		return ".rx(";
	}

}