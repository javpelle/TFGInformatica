package model.test;

import model.testresult.OutputTestResult;
import model.testresult.TestResult;

public class OutputTest extends Test {

	private int shots;
	
	public OutputTest() {
		shots = 0;
	}
	
	@Override
	public int getIDTest() {
		return 2;
	}

	@Override
	public String getNameTest() {
		return "Output Test";
	}

	@Override
	public void setShots(int shots) {
		this.shots = shots;
	}
	
	public int getShots() {
		return shots;
	}

	@Override
	public TestResult newTestResult(String mutantName, int idTest) {
		return new OutputTestResult(mutantName, idTest);
	}

}
