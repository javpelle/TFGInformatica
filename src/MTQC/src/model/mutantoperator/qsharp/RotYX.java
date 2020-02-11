package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public class RotYX implements MutantOperator{
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


