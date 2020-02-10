package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class AndOr implements MutantOperator {

	@Override
	public String getName() {
		return "Or_And ";
	}

	@Override
	public String getDescription() {
		return "Replace And operator by Or operator.";
	}

	@Override
	public String getSearchOperator() {
		return ".and(";
	}

	@Override
	public String getMutantOperator() {
		return ".or(";
	}

}
