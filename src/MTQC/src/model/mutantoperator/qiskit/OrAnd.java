package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class OrAnd implements MutantOperator {

	@Override
	public String getName() {
		return "And_Or";
	}

	@Override
	public String getDescription() {
		return "Replace Or operator by And operator.";
	}

	@Override
	public String getSearchOperator() {
		return ".or(";
	}

	@Override
	public String getMutantOperator() {
		return ".and(";
	}

}
