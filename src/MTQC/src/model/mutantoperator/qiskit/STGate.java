package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class STGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateS_GateT";
	}

	@Override
	public String getDescription() {
		return "Replace S gate with T gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".s(";
	}

	@Override
	public String getMutantOperator() {
		return ".t(";
	}

}