package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class RotXZ extends MutantOperator {
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
