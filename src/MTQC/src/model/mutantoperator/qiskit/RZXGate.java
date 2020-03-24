package model.mutantoperator.qiskit;

public class RZXGate extends QiskitGate {
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