package model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import model.mutant.Mutant;
import model.test.Test;

public class Qiskit {

	private static final String main = "main_qiskit.py";
	
	private static final String init = "init_qiskit.py";

	public static void run(ArrayList<Mutant> mutantList, ArrayList<String> testSuit, Test test, String file,
			String method, double timeLimit) {
		runOriginal(testSuit, test, file, method, timeLimit);
		for (Mutant m: mutantList) {
			runMutant(m, testSuit, test, file, method, timeLimit);
		}
	}

	private static void runOriginal(ArrayList<String> testSuit, Test test, String file, String method,
			double timeLimit) {
		for (String t : testSuit) {
			String aux = generateFile(t, file, method);
			writeFile(init, aux);
			for (int i = 0; i < test.getShots(); i++) {
				runShot(timeLimit);
			}
		}
	}

	private static void runMutant(Mutant mutant, ArrayList<String> testSuit, Test test, String file, String method, double timeLimit) {
		mutant.switchOriginalMutantNames();
		for (String t : testSuit) {
			String aux = generateFile(t, file, method);
			writeFile(init, aux);
			for (int i = 0; i < test.getShots(); i++) {
				runShot(timeLimit);
			}
		}
		mutant.resetOriginalMutantNames();
	}

	private static String runShot(double timeLimit) {
		return null;
	}

	private static String generateFile(String initialize, String file, String method) {
		String header = "from " + file + " import " + method + System.lineSeparator();
		return header + System.lineSeparator() + initialize;
	}

	private static void writeFile(String fileName, String content) {
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch (Exception e) {

		}
	}
}
