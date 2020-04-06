package model.mutantoperator.qsharp;

import model.mutantoperator.MutantOperator;

/**
 * 
 * @author Javier & Luis
 *
 */
public abstract class QSharpConstant extends MutantOperator {
	/**
	 * Especial regex verifier method for QSharp constant type operators
	 */
	public boolean checkRegEx(String matcher) {
		return matcher.matches("\\W" + this.getSearchOperator() + "\\W");
	}
}
