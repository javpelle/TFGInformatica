package model.testresult;

import model.mutant.Mutant;

public class ProbabilisticTestResult implements TestResult {
	
	private int success;
	
	private Mutant mutant;
	
	public ProbabilisticTestResult(Mutant mutant) {
		this.mutant = mutant;
	}
	
	@Override
	public void addShot(int success) {
		this.success = success;		
	}

	@Override
	public String getName() {
		return mutant.toString();
	}

	@Override
	public String getSuccess() {
		if (success == 1) {
			return "Equal result";
		}
		return "Not equivalent mutant";
	}
	
	
}
