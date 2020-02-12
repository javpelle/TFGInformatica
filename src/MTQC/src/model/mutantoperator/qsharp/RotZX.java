package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class RotZX extends MutantOperator {
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
