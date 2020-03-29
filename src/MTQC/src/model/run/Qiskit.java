package model.run;

import java.io.File;

import files.TestFile;

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

}
