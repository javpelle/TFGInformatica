package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateYX implements MutantOperator{
	@Override
	public String getName() {
		return "GateY_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with X gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Y(";
	}

	@Override
	public String getMutantOperator() {
		return "X(";
	}

}


