package model.mutantoperator;

/**
 * Interface
 * 
 */
public interface MutantOperator {

	/**
	 * 
	 * @return operator name showed in the view.
	 */
	public String toString();

	/**
	 * 
	 * @return String with brief mutant description.
	 */
	public String getDescription();

	/**
	 * 
	 * @return The operator that will be replaced.
	 */
	public String getSearchOperator();
	
	/**
	 * 
	 * @return The replacement operator.
	 */
	public String getMutantOperator();

}
