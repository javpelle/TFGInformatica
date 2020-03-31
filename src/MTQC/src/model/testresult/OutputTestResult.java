package model.testresult;

import java.util.ArrayList;

public class OutputTestResult extends TestResult {
	private ArrayList<String> originalResult;
	private ArrayList<String> mutantResult;
	public OutputTestResult(String mutantName, int idTest) {
		super(mutantName, idTest);
		mutantResult = new ArrayList<String>();
	}

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
		this.mutantResult.add(mutantResult);		
	}

	@Override
	public void setOriginalResult(ArrayList<String> originalResult) {
		this.originalResult = originalResult;
	}
	

}
