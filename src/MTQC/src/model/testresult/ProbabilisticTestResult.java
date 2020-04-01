package model.testresult;

public class ProbabilisticTestResult extends TestResult {
	private String result;

	public ProbabilisticTestResult(String mutantName, int idTest) {
		super(mutantName, idTest);

	}

	@Override
	public String getName() {
		return mutantName + "_" + Integer.toString(idTest);
	}

	@Override
	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public void make() {
	}

	public String toString() {
		return result;
	}

	@Override
	public boolean getKill(TestResult original, double confidence) {
		return !result.equals((String) original.getResult());
	}

	@Override
	protected Object getResult() {
		return result;
	}
}
