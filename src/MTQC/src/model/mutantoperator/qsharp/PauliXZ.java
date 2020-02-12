package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class PauliXZ extends MutantOperator {
	@Override
	public String getName() {
		return "PauliX_Z";
	}

	@Override
	public String getDescription() {
		return "Replace PauliX constant with PauliZ constant.";
	}

	@Override
	public String getSearchOperator() {
		return "PauliX";
	}

	@Override
	public String getMutantOperator() {
		return "PauliZ";
	}

}
