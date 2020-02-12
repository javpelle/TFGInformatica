package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class AndOr extends MutantOperator {

	@Override
	public String getName() {
		return "And_Or";
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
