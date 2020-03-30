package model.testresult;

public class ProbabilisticTestResult extends TestResult {
	private String originalResult;
	private String mutantResult;
	
	public ProbabilisticTestResult(String mutantName, int idTest) {
		super(mutantName, idTest);
		
	}

	@Override
	public String getName() {
		return mutantName + "_" + Integer.toString(idTest);
	}

	@Override
	public void setResult(String originalResult, String mutantResult) {
		this.originalResult = originalResult;
		this.mutantResult = mutantResult;
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
