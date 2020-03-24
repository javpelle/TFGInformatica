package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public abstract class QSharpConstant extends MutantOperator {
	public boolean checkRegEx(String matcher) {
		return matcher.matches("\\W" + this.getSearchOperator() + "\\W");
	}
}
