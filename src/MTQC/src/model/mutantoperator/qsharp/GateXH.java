package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateXH implements MutantOperator{
	@Override
	public String getName() {
		return "GateX_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace X gate with Hadamard gate.";
	}

	@Override
	public String getSearchOperator() {
		return "X(";
	}

	@Override
	public String getMutantOperator() {
		return "H(";
	}

}


