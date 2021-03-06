package model.mutantoperator.qiskit;

public class HZGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateH_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace H gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".h(";
	}

	@Override
	public String getMutantOperator() {
		return ".z(";
	}

}