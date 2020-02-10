package model;

import model.mutantoperator.MutantOperator;

/**
 * An observer for UI. Will be notified when model update his state
 */
public interface Observer {
	
	/**
	 * Notifies that something went wrong.
	 * @param msg
	 *            An error message.
	 */
	public void onError(String msg);
	
	/**
	 * Notifies mutant operator list of language.
	 * @param qiskitOperators Mutant operator list
	 */
	public void updateMutantOperators(MutantOperator[] mutantOperatorList);

}
