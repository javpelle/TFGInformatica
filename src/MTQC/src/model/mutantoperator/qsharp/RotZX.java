package model.mutantoperator.qsharp;

public class RotZX extends QSharpGate {
	@Override
	public String getName() {
		return "RotZ_RotX";
	}

	@Override
	public String getDescription() {
		return "Replace rotation over Z axis with rotation over X axis.";
	}

	@Override
	public String getSearchOperator() {
		return "Rz(";
	}

	@Override
	public String getMutantOperator() {
		return "Rx(";
	}

}
