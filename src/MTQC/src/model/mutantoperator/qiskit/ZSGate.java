package model.mutantoperator.qiskit;

public class ZSGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateZ_GateS";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with S gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".z(";
	}

	@Override
	public String getMutantOperator() {
		return ".s(";
	}

}