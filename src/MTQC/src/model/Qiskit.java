package model;

public class Qiskit extends Language {

	protected static final String main = "main_qiskit.py";
	protected static final String init = "init_qiskit.py";

	private static String runShot(double timeLimit) {
		return null;
	}

	private static String generateFile(String initialize, String file, String method) {
		String header = "from " + file + " import " + method + System.lineSeparator();
		return header + System.lineSeparator() + initialize;
	}
	
}
