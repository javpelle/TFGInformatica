package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class PauliYZ extends MutantOperator {
	@Override
	public String getName() {
		return "PauliY_Z";
	}

	@Override
	public String getDescription() {
		return "Replace PauliY constant with PauliZ constant.";
	}

	@Override
	public String getSearchOperator() {
		return "PauliY";
	}

	@Override
	public String getMutantOperator() {
		return "PauliZ";
	}

}
