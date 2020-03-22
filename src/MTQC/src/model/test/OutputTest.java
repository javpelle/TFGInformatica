package model.test;

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

}
