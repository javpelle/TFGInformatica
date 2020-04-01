package model.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import files.TestFile;
import model.test.ProbabilityTest;
import model.test.Test;
import model.testresult.TestResult;

public class QSharp extends Language {

	private static final String method = "MainQuantum";
	private static final String probabilsiticKey = "|";

	protected TestFile generateFile(String completePath, String fileName, String test, int id_test, String methodName,
			String mutantName) {

		StringBuilder fileBuilder = null;
		String file = readFile(completePath);
		String namespaceName = fileName.substring(0, fileName.length() - 3) + Integer.toString(id_test);
		file = changeNamespace(file, namespaceName);
		String mainMethod = getMainMethod(methodName, test);
		mainMethod = tabString(mainMethod);
		fileBuilder = new StringBuilder(file);
		int mainPos = fileBuilder.lastIndexOf("}");
		fileBuilder.insert(mainPos, System.lineSeparator() + System.lineSeparator() + mainMethod);
		writeFile(path + File.separator + namespaceName + ".qs", fileBuilder.toString());

		return new TestFile(mutantName, id_test, path, namespaceName + ".qs");
	}

	private static String changeNamespace(String file, String namespaceName) {
		int ini = file.indexOf("namespace ");
		int end = file.indexOf("{", ini);
		return file.substring(0, ini) + "namespace " + namespaceName + file.substring(end);
	}

	private static String getMainMethod(String methodName, String testInput) {
		String outputType = getOutputType(methodName);
		return getMainHeader() + outputType + "{" + System.lineSeparator() + tabString(testInput)
				+ System.lineSeparator() + "}" + System.lineSeparator();

	}

	private static String getOutputType(String methodName) {
		int index = methodName.lastIndexOf(":", methodName.length());
		return methodName.substring(index);
	}

	private static String getMainHeader() {
		return "operation MainQuantum() ";
	}

	private static String tabString(String input) {
		StringBuilder builder = new StringBuilder(input);
		builder.insert(0, "\t");

		int index = builder.indexOf(System.lineSeparator());
		while (index != -1) {
			builder.replace(index, index + System.lineSeparator().length(), System.lineSeparator() + "\t");
			index += (System.lineSeparator() + "\t").length();
			index = builder.indexOf(System.lineSeparator(), index);
		}
		return builder.toString();
	}

	@Override
	protected String generateImportLanguage() {
		return "import qsharp" + System.lineSeparator();
	}

	@Override
	protected String getMethodCall(String file) {
		return file + "." + method + ".simulate";
	}

	@Override
	protected ArrayList<ArrayList<TestResult>> generateResults(BufferedReader in, ArrayList<ArrayList<TestFile>> files,
			Test test) {
		boolean isProbabilistic = test instanceof ProbabilityTest;
		ArrayList<ArrayList<TestResult>> results = new ArrayList<ArrayList<TestResult>>();
		for (ArrayList<TestFile> list : files) {
			ArrayList<TestResult> aux = new ArrayList<TestResult>();
			for (int t = 0; t < list.size(); t++) {
				TestResult tr = test.newTestResult(list.get(t).getMutantName(), list.get(t).getIdTest());
				for (int i = 0; i < test.getShots(); i++) {
					if (isProbabilistic) {
						tr.setResult(readLineProbabilistic(in));
					} else {
						tr.setResult(readLine(in));
					}
				}
				tr.make();
				aux.add(tr);
			}
			results.add(aux);
		}
		return results;
	}

	private String readLineProbabilistic(BufferedReader in) {
		String line = null;
		String result = "";
		try {
			do {
				line = in.readLine();
			} while (line != null && !line.startsWith(probabilsiticKey));
			do {
				result = result + line.substring(line.indexOf("["), line.indexOf("]") + 1); 
				line = in.readLine();		
			} while (line.startsWith(probabilsiticKey));
		} catch (IOException e) {
			return "Error";
		}
		return result;
	}
}
