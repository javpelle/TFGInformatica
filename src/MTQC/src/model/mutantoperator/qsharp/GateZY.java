package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateZY extends MutantOperator {
	@Override
	public String getName() {
		return "GateZ_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Z(";
	}

	@Override
	public String getMutantOperator() {
		return "Y(";
	}

}
