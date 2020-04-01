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
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
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
}
