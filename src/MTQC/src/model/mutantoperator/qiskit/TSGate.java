package model.mutantoperator.qiskit;

public class TSGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateT_GateS";
	}

	@Override
	public String getDescription() {
		return "Replace T gate with S gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".t(";
	}

	@Override
	public String getMutantOperator() {
		return ".s(";
	}

}