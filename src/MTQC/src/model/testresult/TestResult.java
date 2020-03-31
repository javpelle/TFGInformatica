package model.testresult;

import java.util.ArrayList;

public abstract class TestResult {
	protected String mutantName;
	protected int idTest;
	
	public TestResult(String mutantName, int idTest) {
		this.mutantName = mutantName;
		this.idTest = idTest;
	}
	public abstract String getName();
	
	public abstract void setMutantResult(String mutantResult);
	public abstract void setOriginalResult(ArrayList<String> originalResult);
	public abstract String getResult(); 
}
