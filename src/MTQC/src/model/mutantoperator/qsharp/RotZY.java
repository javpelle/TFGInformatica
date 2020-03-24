package model.mutantoperator.qsharp;

public class RotZY extends QSharpGate {
	@Override
	public String getName() {
		return "RotZ_RotY";
	}

	@Override
	public String getDescription() {
		return "Replace rotation over Z axis with rotation over Z axis.";
	}

	@Override
	public String getSearchOperator() {
		return "Rz(";
	}

	@Override
	public String getMutantOperator() {
		return "Ry(";
	}

}
