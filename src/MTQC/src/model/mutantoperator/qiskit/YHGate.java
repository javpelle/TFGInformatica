package model.mutantoperator.qiskit;

public class YHGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateY_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with H gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".y(";
	}

	@Override
	public String getMutantOperator() {
		return ".h(";
	}

}