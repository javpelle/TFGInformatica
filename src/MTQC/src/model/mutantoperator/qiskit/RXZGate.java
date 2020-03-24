package model.mutantoperator.qiskit;

public class RXZGate extends QiskitGate {
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