package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

public abstract class QSharpGate extends MutantOperator{
public boolean checkRegEx(String matcher){
		String noParenthesis = getSearchOperator().substring(0,getSearchOperator().length() - 1);
		return matcher.matches("\\W" + noParenthesis + ".*");	
	}
}
