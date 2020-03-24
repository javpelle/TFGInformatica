package model.mutantoperator.qsharp;

public class MissAdjoint extends QSharpConstant {
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
		return "Adjoint";
	}

	@Override
	public String getMutantOperator() {
		return "";
	}

}
