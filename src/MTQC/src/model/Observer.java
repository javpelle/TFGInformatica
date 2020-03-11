package model;

import java.util.ArrayList;

import model.mutant.Mutant;
import model.mutantoperator.MutantOperator;
import model.test.Test;

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
	
	public void updatePath(ArrayList<String> files);

	public void updateMutants(ArrayList<Mutant> mutantList);

	public void updateFileMethods(ArrayList<String> fileMethods);

	public void setTests(Test[] tests);

}
