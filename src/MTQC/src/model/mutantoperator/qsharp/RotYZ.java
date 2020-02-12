package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class RotYZ extends MutantOperator {
	@Override
	public String getName() {
		return "RotY_RotZ";
	}

	@Override
	public String getDescription() {
		return "Replace rotation over Y axis with rotation over Z axis.";
	}

	@Override
	public String getSearchOperator() {
		return "Ry(";
	}

	@Override
	public String getMutantOperator() {
		return "Rz(";
	}

}
