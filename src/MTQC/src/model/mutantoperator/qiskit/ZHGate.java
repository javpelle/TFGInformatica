package model.mutantoperator.qiskit;

public class ZHGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateZ_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with H gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".z(";
	}

	@Override
	public String getMutantOperator() {
		return ".h(";
	}

}