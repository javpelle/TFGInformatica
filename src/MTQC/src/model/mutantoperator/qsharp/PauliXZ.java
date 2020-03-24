package model.mutantoperator.qsharp;

public class PauliXZ extends QSharpConstant {
	@Override
	public String getName() {
		return "PauliX_Z";
	}

	@Override
	public String getDescription() {
		return "Replace PauliX constant with PauliZ constant.";
	}

	@Override
	public String getSearchOperator() {
		return "PauliX";
	}

	@Override
	public String getMutantOperator() {
		return "PauliZ";
	}

}
