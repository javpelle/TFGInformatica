package model.mutantoperator.qsharp;

public class PauliXY extends QSharpConstant {
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
