package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateXY implements MutantOperator{
	@Override
	public String getName() {
		return "GateX_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace X gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return "X(";
	}

	@Override
	public String getMutantOperator() {
		return "Y(";
	}

}


