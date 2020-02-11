package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateYZ implements MutantOperator{
	@Override
	public String getName() {
		return "GateY_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Y(";
	}

	@Override
	public String getMutantOperator() {
		return "Z(";
	}

}


