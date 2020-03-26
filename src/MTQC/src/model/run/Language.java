package model.run;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import files.TestFile;
import model.mutant.Mutant;
import model.test.Test;

public abstract class Language {

	protected static String main = "";

	public void run(ArrayList<Mutant> mutantList, ArrayList<String> testSuit, Test test, String file, String method,
			double timeLimit) {
		ArrayList<ArrayList<TestFile>> files = generateFiles(mutantList, testSuit);
		generateMain(files, test, timeLimit);
	}

	protected abstract void generateMain(ArrayList<ArrayList<TestFile>> files, Test test, double timeLimit);

	protected ArrayList<ArrayList<TestFile>> generateFiles(ArrayList<Mutant> mutantList, ArrayList<String> testSuit) {
		ArrayList<ArrayList<TestFile>> files = new ArrayList<ArrayList<TestFile>>();

		ArrayList<TestFile> aux = new ArrayList<TestFile>();
		for (int i = 0; i < testSuit.size(); i++) {
			aux.add(generateFile(mutantList.get(0).getOriginalCompletePath(), testSuit.get(i), i));
		}
		files.add(aux);

		for (Mutant m : mutantList) {
			ArrayList<TestFile> aux2 = new ArrayList<TestFile>();
			for (int i = 0; i < testSuit.size(); i++) {
				aux2.add(generateFile(m.getMutantCompletePath(), testSuit.get(i), i));
			}
			files.add(aux2);
		}
		return files;
	}

	protected abstract TestFile generateFile(String pathFile, String test, int id_test);

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
}
