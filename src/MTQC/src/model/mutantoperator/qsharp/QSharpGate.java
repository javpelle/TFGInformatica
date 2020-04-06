package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

/**
 * 
 * @author Javier & Luis
 *
 */
public abstract class QSharpGate extends MutantOperator {
	/**
	 * Especial regex verifier method for QSharp gate type operators
	 */
	public boolean checkRegEx(String matcher) {
		String noParenthesis = getSearchOperator().substring(0, getSearchOperator().length() - 1);
		return matcher.matches("\\W" + noParenthesis + ".*");
	}
}
