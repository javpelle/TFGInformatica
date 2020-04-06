package model.mutantoperator;

/**
 * Interface
 * 
 */
public abstract class MutantOperator {

	/**
	 * 
	 * @return operator name showed in the view.
	 */
	public abstract String getName();

	/**
	 * 
	 * @return String with brief mutant description.
	 */
	public abstract String getDescription();

	/**
	 * 
	 * @return The operator that will be replaced.
	 */
	public abstract String getSearchOperator();

	/**
	 * 
	 * @return The replacement operator.
	 */
	public abstract String getMutantOperator();

	/**
	 * Checks if a strings verifies some regular expression
	 * 
	 * @param String to be cheked
	 * @return True if matcher verifies regex. False in other case.
	 */
	public abstract boolean checkRegEx(String matcher);
	
	/**
	 * Override of Object toString method
	 */
	public String toString() {
		return getName();
	}

}
