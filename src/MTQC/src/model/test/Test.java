package model.test;

public abstract class Test {
	
	public abstract int getIDTest();
	
	public abstract String getNameTest();
	
	public abstract void setShots(int shots);
	
	public abstract int getShots();
	
	public String toString() {
		return getNameTest();
	}
}
