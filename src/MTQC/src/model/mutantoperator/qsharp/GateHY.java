package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateHY implements MutantOperator{
	@Override
	public String getName() {
		return "GateH_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace Hadamard gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return "H(";
	}

	@Override
	public String getMutantOperator() {
		return "Y(";
	}

}


