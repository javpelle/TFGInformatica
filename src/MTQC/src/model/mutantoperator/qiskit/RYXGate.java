package model.mutantoperator.qiskit;

public class RYXGate extends QiskitGate {
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