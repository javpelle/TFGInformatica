package model.testresult;

import model.mutant.Mutant;

public class OutputTestResult implements TestResult {

	private double success;

	private double iterations;

	private Mutant mutant;

	public OutputTestResult(Mutant mutant) {
		this.mutant = mutant;
		success = 0;
		iterations = 0;
	}

	@Override
	public void addShot(int success) {
		this.success += success;
		iterations++;
	}

	public String getName() {
		return mutant.toString();
	}

	public String getSuccess() {
		double percentage = (double) Math.round(success / iterations * 1000) / 10;
		return "Equal result in " + String.valueOf(percentage) + "% iterations";
	}

}
