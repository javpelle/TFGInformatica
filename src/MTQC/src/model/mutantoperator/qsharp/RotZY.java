package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class RotZY implements MutantOperator{
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

