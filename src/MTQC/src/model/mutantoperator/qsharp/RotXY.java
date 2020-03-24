package model.mutantoperator.qsharp;

public class RotXY extends QSharpGate {
	@Override
	public String getName() {
		return "RotX_RotY";
	}

	@Override
	public String getDescription() {
		return "Replace rotation over X axis with rotation over Y axis.";
	}

	@Override
	public String getSearchOperator() {
		return "Rx(";
	}

	@Override
	public String getMutantOperator() {
		return "Ry(";
	}

}
