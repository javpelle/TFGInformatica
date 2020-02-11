package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class PauliZX implements MutantOperator{
	@Override
	public String getName() {
		return "PauliZ_X";
	}

	@Override
	public String getDescription() {
		return "Replace PauliZ constant with PauliX constant.";
	}

	@Override
	public String getSearchOperator() {
		return "PauliZ";
	}

	@Override
	public String getMutantOperator() {
		return "PauliX";
	}

}


