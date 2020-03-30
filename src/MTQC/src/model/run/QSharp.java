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

	public QSharp(NotifyListener listener) {
		super(listener);
	}

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
	protected void generateResults(BufferedReader in, ArrayList<ArrayList<TestFile>> files, Test test) {
		boolean isProbabilistic = test instanceof ProbabilityTest;
		for (TestFile t : files.get(0)) {		
		}
		for (ArrayList<TestFile> list : files.subList(1, files.size())) {
			for (TestFile t : list) {
				TestResult tr = test.newTestResult(t.getMutantName(), t.getIdTest());
				if (isProbabilistic) {
					generateProbabilisticResult(tr);
				}
				
			}
		}
		String ret;
		try {
			ret = in.readLine();
			while (ret != null) {
				System.out.println(ret);
				ret = in.readLine();
			}
		} catch (IOException e) {
		}

	}

	private ArrayList<String> generateProbabilisticResult(TestResult tr) {
		return null;
		// TODO Auto-generated method stub	
	}

}
