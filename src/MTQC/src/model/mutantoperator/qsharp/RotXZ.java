package model.mutantoperator.qsharp;

public class RotXZ extends QSharpGate {
	@Override
	public String getName() {
		return "RotX_RotZ";
	}

	@Override
	public String getDescription() {
		return "Replace rotation over X axis with rotation over Z axis.";
	}

	@Override
	public String getSearchOperator() {
		return "Rx(";
	}

	@Override
	public String getMutantOperator() {
		return "Rz(";
	}

}
