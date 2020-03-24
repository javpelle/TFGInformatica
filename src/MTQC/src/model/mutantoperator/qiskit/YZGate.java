package model.mutantoperator.qiskit;

public class YZGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateY_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".y(";
	}

	@Override
	public String getMutantOperator() {
		return ".z(";
	}

}