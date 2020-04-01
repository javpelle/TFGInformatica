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

	public abstract String getResult();

	public abstract void make();
}
