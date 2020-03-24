package model.mutantoperator.qiskit;

public class ZYGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateZ_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".z(";
	}

	@Override
	public String getMutantOperator() {
		return ".y(";
	}

}