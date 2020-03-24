package model.mutantoperator.qiskit;

public class XYGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateX_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace X gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".x(";
	}

	@Override
	public String getMutantOperator() {
		return ".y(";
	}

}