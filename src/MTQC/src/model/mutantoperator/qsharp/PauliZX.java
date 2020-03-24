package model.mutantoperator.qsharp;

public class PauliZX extends QSharpConstant {
	@Override
	public String getName() {
		return "PauliZ_X";
	}

	@Override
	public String getDescription() {
		return "Replace PauliZ constant with PauliX constant.";
	}

	@Override
	public String getSearchOperator() {
		return "PauliZ";
	}

	@Override
	public String getMutantOperator() {
		return "PauliX";
	}

}
