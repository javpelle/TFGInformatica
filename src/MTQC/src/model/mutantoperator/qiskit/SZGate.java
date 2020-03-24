package model.mutantoperator.qiskit;

public class SZGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateS_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace S gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".s(";
	}

	@Override
	public String getMutantOperator() {
		return ".z(";
	}

}