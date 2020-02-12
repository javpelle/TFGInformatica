package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateHX extends MutantOperator{
	@Override
	public String getName() {
		return "GateH_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace Hadamard gate with X gate.";
	}

	@Override
	public String getSearchOperator() {
		return "H(";
	}

	@Override
	public String getMutantOperator() {
		return "X(";
	}

}


