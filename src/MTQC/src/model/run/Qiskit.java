package model.run;

import java.io.BufferedReader;
import java.io.File;
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
	protected ArrayList<ArrayList<TestResult>> generateResults(BufferedReader in, ArrayList<ArrayList<TestFile>> files,
			Test test) {
		ArrayList<ArrayList<TestResult>> results = new ArrayList<ArrayList<TestResult>>();
		for (ArrayList<TestFile> list : files) {
			ArrayList<TestResult> aux = new ArrayList<TestResult>();
			for (int t = 0; t < list.size(); t++) {
				TestResult tr = test.newTestResult(list.get(t).getMutantName(), list.get(t).getIdTest());
				for (int i = 0; i < test.getShots(); i++) {
					tr.setResult(readLine(in));
				}
				tr.make();
				aux.add(tr);
			}
			results.add(aux);
		}
		return results;
	}

	@Override
	protected String isProbQsharp(Test test) {
		return "";
	}

}
