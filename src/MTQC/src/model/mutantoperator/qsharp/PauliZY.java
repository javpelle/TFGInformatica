package model.mutantoperator.qsharp;

public class PauliZY extends QSharpConstant {
	@Override
	public String getName() {
		return "PauliZ_Y";
	}

	@Override
	public String getDescription() {
		return "Replace PauliZ constant with PauliY constant.";
	}

	@Override
	public String getSearchOperator() {
		return "PauliZ";
	}

	@Override
	public String getMutantOperator() {
		return "PauliY";
	}

}
