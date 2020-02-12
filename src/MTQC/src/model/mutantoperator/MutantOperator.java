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
	
	public String toString() {
		return getName();
	}

}
