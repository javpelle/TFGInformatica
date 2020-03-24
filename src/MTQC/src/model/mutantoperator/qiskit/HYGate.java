package model.mutantoperator.qiskit;

public class HYGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateH_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace H gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".h(";
	}

	@Override
	public String getMutantOperator() {
		return ".y(";
	}

}