package model.run;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

import files.TestFile;
import model.test.Test;

public class Qiskit extends Language {

	public Qiskit(NotifyListener listener) {
		super(listener);
	}

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
	protected void generateResults(BufferedReader in, ArrayList<ArrayList<TestFile>> files, Test test) {
		// TODO Auto-generated method stub
		
	}

}
