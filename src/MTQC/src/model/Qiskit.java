package model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import model.mutant.Mutant;

public class Qiskit {

	public static void run(ArrayList<Mutant> mutantList, ArrayList<String> testSuit) {
		String aux = generateFile("def init():", "hola.py", "hola");
		generateFile("main1.py", aux);
		generateFile("main2.py", aux);
	}

	private static String generateFile(String initialize, String file, String method) {
		String header = "from " + file + " import " + method + System.lineSeparator();
		return header + System.lineSeparator() + initialize;
	}

	private static void generateFile(String fileName, String content) {
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch(Exception e) {
			
		}
	}
}
