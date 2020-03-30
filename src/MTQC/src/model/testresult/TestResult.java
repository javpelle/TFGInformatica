package model.testresult;

public abstract class TestResult {
	protected String mutantName;
	protected int idTest;
	
	public TestResult(String mutantName, int idTest) {
		this.mutantName = mutantName;
		this.idTest = idTest;
	}
	public abstract String getName();
	
	public abstract void setResult(String originalResult, String mutantResult);
	public abstract String getResult(); 
}
