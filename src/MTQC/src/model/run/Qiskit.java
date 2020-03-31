package model.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import files.TestFile;
import model.test.Test;
import model.testresult.TestResult;

public class Qiskit extends Language {

	private static final String method = "init";

	protected TestFile generateFile(String completePath, String fileName, String test, int id_test, String methodName,
			String mutantName) {
		String file = readFile(completePath);
		String newFileName = fileName.substring(0, fileName.length() - 3) + Integer.toString(id_test) + ".py";
		file = "from qiskit import *" + System.lineSeparator() + System.lineSeparator() + file + System.lineSeparator()
				+ test;
		writeFile(path + File.separator + newFileName, file);

		return new TestFile(mutantName, id_test, path, newFileName);
	}

	@Override
	protected String generateImportLanguage() {
		return "from qiskit import *" + System.lineSeparator();
	}

	@Override
	protected String getMethodCall(String file) {
		return file + "." + method;
	}

	@Override
	protected ArrayList<ArrayList<TestResult>> generateResults(BufferedReader in, ArrayList<ArrayList<TestFile>> files, Test test) {
		ArrayList<ArrayList<TestResult>> results = new ArrayList<ArrayList<TestResult>>();
		ArrayList<ArrayList<String>> original = new ArrayList<ArrayList<String>>();
		for (int t = 0; t < files.get(0).size(); t++) {
			ArrayList<String> aux = new ArrayList<String>();
			for (int i = 0; i < test.getShots(); i++) {
				try {
					aux.add(in.readLine());
				} catch (IOException e) {
					aux.add("Error");
				}
			}
			original.add(aux);
		}
		for (ArrayList<TestFile> list : files.subList(1, files.size())) {
			ArrayList<TestResult> aux = new ArrayList<TestResult>();
			for (int t = 0; t < list.size(); t++) {
				TestResult tr = test.newTestResult(list.get(t).getMutantName(), list.get(t).getIdTest());
				tr.setOriginalResult(original.get(t));
				for (int i = 0; i < test.getShots(); i++) {
					try {
						tr.setMutantResult(in.readLine());
					} catch (IOException e) {
						tr.setMutantResult("Error");
					}
				} 
				aux.add(tr);				
			}
			results.add(aux);
		}
		return results;
	}

}
