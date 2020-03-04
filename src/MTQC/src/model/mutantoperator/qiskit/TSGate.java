package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class TSGate extends MutantOperator {
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