package model.testresult;

import java.util.ArrayList;

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
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMutantResult(String mutantResult) {
		this.mutantResult = mutantResult;
	}

	@Override
	public void setOriginalResult(ArrayList<String> originalResult) {
		this.originalResult = originalResult.get(0);		
	}

}
