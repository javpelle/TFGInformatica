package model.mutantoperator.qsharp;

public class PauliYZ extends QSharpConstant {
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
