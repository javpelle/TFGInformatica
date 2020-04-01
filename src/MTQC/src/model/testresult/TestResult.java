package model.testresult;

public abstract class TestResult {
	protected String mutantName;
	protected int idTest;

	public TestResult(String mutantName, int idTest) {
		this.mutantName = mutantName;
		this.idTest = idTest;
	}

	public abstract String getName();

	public abstract void setResult(String result);

	public abstract void make();
	
	public abstract boolean getKill(TestResult original, double confidence);
	
	protected abstract Object getResult();
}
