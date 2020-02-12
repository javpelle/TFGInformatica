package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class GateHZ extends MutantOperator {
	@Override
	public String getName() {
		return "GateH_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace Hadamard gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return "H(";
	}

	@Override
	public String getMutantOperator() {
		return "Z(";
	}

}
