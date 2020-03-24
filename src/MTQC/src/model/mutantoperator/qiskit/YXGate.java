package model.mutantoperator.qiskit;

public class YXGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateY_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with X gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".y(";
	}

	@Override
	public String getMutantOperator() {
		return ".x(";
	}

}