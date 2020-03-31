package model.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import files.TestFile;
import model.mutant.Mutant;
import model.test.Test;
import model.testresult.TestResult;

public abstract class Language {

	protected static final String path = "python";
	protected static final String main = "main_mtqc.py";
	protected static final String key = "_mtqc_";

	public ArrayList<ArrayList<TestResult>> run(ArrayList<Mutant> mutantList, ArrayList<String> testSuit, Test test,
			String file, String method, double timeLimit) {
		ArrayList<ArrayList<TestResult>> ret;
		ArrayList<ArrayList<TestFile>> files = generateFiles(mutantList, testSuit, method);
		generatePythonScript(files, test, timeLimit);
		ret = runMain(files, test);
		deleteFiles(files);
		return ret;
	}

	private void deleteFiles(ArrayList<ArrayList<TestFile>> files) {
		for (ArrayList<TestFile> list : files) {
			for (TestFile t : list) {
				deleteFile(t.getCompletePath());
			}
		}
		deleteFile(path + File.separator + main);
	}

	private void deleteFile(String file) {
		try {
			File f = new File(file); // file to be delete
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ArrayList<ArrayList<TestResult>> runMain(ArrayList<ArrayList<TestFile>> files, Test test) {
		try {
			Process p = Runtime.getRuntime().exec(pythonCall(path, main));
			p.waitFor();
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			return generateResults(in, files, test);
		} catch (IOException | InterruptedException e) {

		}
		return null;
	}

	protected void generatePythonScript(ArrayList<ArrayList<TestFile>> files, Test test, double timeLimit) {
		String script = generateImportLanguage();
		script += System.lineSeparator();
		script += "from tools import run_shots" + System.lineSeparator();
		for (ArrayList<TestFile> list : files) {
			for (TestFile t : list) {
				script += "import " + t.getFileName() + System.lineSeparator();
			}
		}
		script += System.lineSeparator();
		script += "if __name__ == '__main__':" + System.lineSeparator();
		for (ArrayList<TestFile> list : files) {
			for (TestFile t : list) {
				script += "\trun_shots(" + getMethodCall(t.getFileName()) + ", " + String.valueOf(timeLimit) + ", "
						+ String.valueOf(test.getShots()) + ")" + System.lineSeparator();
			}
		}
		writeFile(path + File.separator + main, script);
	}

	protected abstract String generateImportLanguage();

	protected ArrayList<ArrayList<TestFile>> generateFiles(ArrayList<Mutant> mutantList, ArrayList<String> testSuit,
			String method) {
		ArrayList<ArrayList<TestFile>> files = new ArrayList<ArrayList<TestFile>>();

		ArrayList<TestFile> aux = new ArrayList<TestFile>();
		for (int i = 0; i < testSuit.size(); i++) {
			aux.add(generateFile(mutantList.get(0).getOriginalCompletePath(), mutantList.get(0).getOriginalName(),
					testSuit.get(i), i, method, "original"));
		}
		files.add(aux);

		for (Mutant m : mutantList) {
			ArrayList<TestFile> aux2 = new ArrayList<TestFile>();
			for (int i = 0; i < testSuit.size(); i++) {
				aux2.add(generateFile(m.getMutantCompletePath(), m.getMutantFileName(), testSuit.get(i), i, method,
						m.getName()));
			}
			files.add(aux2);
		}
		return files;
	}

	protected abstract TestFile generateFile(String completePath, String fileName, String test, int id_test,
			String method, String mutantName);

	protected abstract String getMethodCall(String file);

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

	protected String[] pythonCall(String path, String file) {
		if (System.getProperty("os.name").startsWith("Windows")) {
			// We are running this software in Windows OS
			// QSharp python script must run from the same path as the methods it calls cuz
			// ...?
			return new String[] { "cmd.exe", "/c", "cd", path, "&&", "python", file, "&&", "cd", ".." };
		} else {
			return new String[] { "/bin/bash", "-c", "cd", path, "&&", "python", file, "&&", "cd", ".." };
		}
	}

	protected String readFile(String fileName) {
		File originalFile = new File(fileName);
		String file = "";
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(originalFile));
			String line = reader.readLine();

			while (line != null) {
				file = file + line + System.lineSeparator();
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {

		}
		return file;
	}

	protected abstract ArrayList<ArrayList<TestResult>> generateResults(BufferedReader in,
			ArrayList<ArrayList<TestFile>> files, Test test);
}
