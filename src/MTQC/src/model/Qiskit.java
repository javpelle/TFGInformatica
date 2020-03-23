package model;

public class Qiskit extends Language {

	public Qiskit(){
		main = "main_qiskit.py";
		init = "init_qiskit.py";	
	}
	
	protected String runShot(double timeLimit) {
		return null;
	}

	protected String generateFile(String initialize, String file, String method) {
		String header = "from " + file + " import " + method + System.lineSeparator();
		return header + System.lineSeparator() + initialize;
	}
	
}
