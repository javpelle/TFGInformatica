package model.test;

public abstract class Test {
	
	public abstract int getIDTest();
	
	public abstract String getNameTest();
	
	public String toString() {
		return getNameTest();
	}
}
