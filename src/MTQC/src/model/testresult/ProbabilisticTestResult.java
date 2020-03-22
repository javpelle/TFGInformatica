package model.testresult;

import model.mutant.Mutant;

public class ProbabilisticTestResult implements TestResult {
	
	private String result;
	
	private Mutant mutant;
	
	public ProbabilisticTestResult(Mutant mutant, String result) {
		this.mutant = mutant;
		this.result = result;
	}
	
	public ProbabilisticTestResult(String result) {
		mutant = null;
		this.result = result;
	}

	@Override
	public String getName() {
		return mutant.toString();
	}
	
	public String getResult() {
		return result;
	}

	
	
	
}
