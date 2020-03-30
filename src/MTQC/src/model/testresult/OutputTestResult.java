package model.testresult;

import java.util.ArrayList;

public class OutputTestResult extends TestResult {
	private ArrayList<String> originalResult;
	private ArrayList<String> mutantResult;
	public OutputTestResult(String mutantName, int idTest) {
		super(mutantName, idTest);
		originalResult = new ArrayList<String>();
		mutantResult = new ArrayList<String>();
	}

	public String getName() {
		return mutantName + "_" + Integer.toString(idTest);
	}
	

	@Override
	public void setResult(String originalResult, String mutantResult) {
		this.originalResult.add(originalResult);
		this.mutantResult.add(mutantResult);
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
