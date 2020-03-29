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

public abstract class Language {

	protected static final String path = "python";
	protected static final String main = "main_mtqc.py";

	public void run(ArrayList<Mutant> mutantList, ArrayList<String> testSuit, Test test, String file, String method,
			double timeLimit) {
		ArrayList<ArrayList<TestFile>> files = generateFiles(mutantList, testSuit, method);
		generatePythonScript(files, test, timeLimit);
		runMain();
		deleteFiles(files);
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

	private void runMain() {
		String ret = null;
		try {

			Process p = Runtime.getRuntime().exec(pythonCall(path + File.separator + main));
			p.waitFor();
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			ret = in.readLine();
			while (ret != null) {
				System.out.println(ret);
				ret = in.readLine();
			}
		} catch (IOException | InterruptedException e) {

		}

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

	protected String[] pythonCall(String file) {
		if (System.getProperty("os.name").startsWith("Windows")) {
			// We are running this software in Windows OS
			return new String[] { "cmd.exe", "/c", "python", file };
		} else {
			return new String[] { "/bin/bash", "-c", "python", file };
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
}
