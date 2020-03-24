package model.mutantoperator.qiskit;

public class RZYGate extends QiskitGate {
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