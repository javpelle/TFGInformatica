package model.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import files.TestFile;
import model.test.Test;

public class Qiskit extends Language {

	public Qiskit() {
		path = "qiskit";
		main = "main_qiskit.py";
		File file = new File(path);
		file.mkdir();
	}

	protected TestFile generateFile(String completePath, String fileName, String test, int id_test, String methodName,
			String mutantName) {
		String file = readFile(completePath);
		String newFileName = fileName.substring(0, fileName.length() - 3) + Integer.toString(id_test) + ".py";
		file = "from qiskit import *" + System.lineSeparator()
				+ System.lineSeparator() + file + System.lineSeparator() + test;
		writeFile(path + File.separator + newFileName, file);

		return new TestFile(mutantName, id_test, path, newFileName);
	}

	protected String runShot(double timeLimit) {
		String ret = null;
		try {

			Process p = Runtime.getRuntime().exec( pythonCall(path + File.separator + main));
			if (!p.waitFor((long) timeLimit, TimeUnit.SECONDS)) {
				// timeout - kill the process.
				p.destroy(); // consider using destroyForcibly instead
			} else {
				BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
				ret = in.readLine();
			}
		} catch (IOException | InterruptedException e) {

		}
		if (ret.equals("null")) {
			ret = null;
		}
		return ret;
	}

	protected String generateFile(String initialize, String file, String method) {
		String path = "";
		String header = "import sys" + System.lineSeparator();
		header += "sys.path.insert(0, " + path + ")" + System.lineSeparator();
		header += "from " + file + " import " + method + System.lineSeparator();
		return header + System.lineSeparator() + initialize;
	}

	@Override
	protected void generatePythonScript(ArrayList<ArrayList<TestFile>> files, Test test, double timeLimit) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String generateImportLanguage() {
		return "";
	}

}
