package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateZX implements MutantOperator{
	@Override
	public String getName() {
		return "GateZ_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with X gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Z(";
	}

	@Override
	public String getMutantOperator() {
		return "X(";
	}

}


