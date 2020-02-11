package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class MissAdjoint implements MutantOperator{
	@Override
	public String getName() {
		return "MissAdjoint";
	}

	@Override
	public String getDescription() {
		return "Deletes the adjoint functor from a method call.";
	}

	@Override
	public String getSearchOperator() {
		return "Adjoint ";
	}

	@Override
	public String getMutantOperator() {
		return "";
	}

}


