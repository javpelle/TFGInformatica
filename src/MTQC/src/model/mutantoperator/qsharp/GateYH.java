package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateYH implements MutantOperator{
	@Override
	public String getName() {
		return "GateY_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with Hadamard gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Y(";
	}

	@Override
	public String getMutantOperator() {
		return "H(";
	}

}


