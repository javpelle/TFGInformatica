package model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import model.mutant.Mutant;
import model.test.Test;

public abstract class Language {
	protected static String main = "";
	protected static String init = "";
	

	public void run(ArrayList<Mutant> mutantList, ArrayList<String> testSuit, Test test, String file,
			String method, double timeLimit) {
		runOriginal(testSuit, test, file, method, timeLimit);
		for (Mutant m: mutantList) {
			runMutant(m, testSuit, test, file, method, timeLimit);
		}
	}
	
	protected void runOriginal(ArrayList<String> testSuit, Test test, String file, String method,
			double timeLimit) {
		for (String t : testSuit) {
			String aux = generateFile(file, method, t);
			writeFile(init, aux);
			for (int i = 0; i < test.getShots(); i++) {
				runShot(timeLimit);
			}
		}
	}
	
	
	protected void runMutant(Mutant mutant, ArrayList<String> testSuit, Test test, String file, String method, double timeLimit) {
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
	
	protected abstract String generateFile(String fileName, String methodName, String test);
	
	protected  abstract String runShot(double timeLimit);
	
	protected void writeFile(String fileName, String content) {
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
