package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateZH extends MutantOperator {
	@Override
	public String getName() {
		return "GateZ_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with Hadamard gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Z(";
	}

	@Override
	public String getMutantOperator() {
		return "H(";
	}

}
