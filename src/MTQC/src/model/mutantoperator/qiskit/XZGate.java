package model.mutantoperator.qiskit;

public class XZGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateX_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace X gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".x(";
	}

	@Override
	public String getMutantOperator() {
		return ".z(";
	}

}