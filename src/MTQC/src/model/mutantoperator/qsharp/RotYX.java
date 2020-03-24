package model.mutantoperator.qsharp;

public class RotYX extends QSharpGate {
	@Override
	public String getName() {
		return "RotY_RotX";
	}

	@Override
	public String getDescription() {
		return "Replace rotation over Y axis with rotation over X axis.";
	}

	@Override
	public String getSearchOperator() {
		return "Ry(";
	}

	@Override
	public String getMutantOperator() {
		return "Rx(";
	}

}
