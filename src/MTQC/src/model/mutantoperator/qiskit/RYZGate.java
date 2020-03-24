package model.mutantoperator.qiskit;

public class RYZGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateRY_GateRZ";
	}

	@Override
	public String getDescription() {
		return "Replace RY gate with RZ gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ry(";
	}

	@Override
	public String getMutantOperator() {
		return ".rz(";
	}

}