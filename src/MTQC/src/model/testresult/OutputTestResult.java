package model.testresult;

import model.mutant.Mutant;

public class OutputTestResult implements TestResult {

	private double success;

	private Mutant mutant;

	public OutputTestResult(Mutant mutant) {
		this.mutant = mutant;
		success = 0;
	}

	public void addShot(String result) {
		this.success += success;
	}

	public String getName() {
		return mutant.toString();
	}

}
