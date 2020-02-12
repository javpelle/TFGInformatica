package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class PauliXY extends MutantOperator {
	@Override
	public String getName() {
		return "PauliX_Y";
	}

	@Override
	public String getDescription() {
		return "Replace PauliX constant with PauliY constant.";
	}

	@Override
	public String getSearchOperator() {
		return "PauliX";
	}

	@Override
	public String getMutantOperator() {
		return "PauliY";
	}

}
