package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateTS implements MutantOperator{
	@Override
	public String getName() {
		return "GateT_GateS";
	}

	@Override
	public String getDescription() {
		return "Replace T( gate with S gate.";
	}

	@Override
	public String getSearchOperator() {
		return "T(";
	}

	@Override
	public String getMutantOperator() {
		return "S(";
	}

}


