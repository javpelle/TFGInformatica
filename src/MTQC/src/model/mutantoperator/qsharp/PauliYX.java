package model.mutantoperator.qsharp;

public class PauliYX extends QSharpConstant {
	@Override
	public String getName() {
		return "PauliY_X";
	}

	@Override
	public String getDescription() {
		return "Replace PauliY constant with PauliX constant.";
	}

	@Override
	public String getSearchOperator() {
		return "PauliY";
	}

	@Override
	public String getMutantOperator() {
		return "PauliX";
	}

}
