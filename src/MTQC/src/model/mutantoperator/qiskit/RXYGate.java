package model.mutantoperator.qiskit;

public class RXYGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateRX_GateRY";
	}

	@Override
	public String getDescription() {
		return "Replace RX gate with RY gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".rx(";
	}

	@Override
	public String getMutantOperator() {
		return ".ry(";
	}

}