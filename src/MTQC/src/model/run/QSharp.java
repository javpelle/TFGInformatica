package model.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import files.TestFile;
import model.test.Test;

public class QSharp extends Language {

	private static final String path = "qSharp";
	private static final String main = "main_qSharp.py";

	protected TestFile generateFile(String completePath, String fileName, String test, int id_test, String methodName,
			String mutantName) {

		StringBuilder fileBuilder = null;
		String file = readFile(completePath);
		String namespaceName = fileName.substring(0, fileName.length() - 3) + Integer.toString(id_test) ;
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
	protected void generatePythonScript(ArrayList<ArrayList<TestFile>> files, Test test, double timeLimit) {
		

	}

	/*
	 * NOT IN USE
	 * 
	 * private static String getMethodCall(String methodName, int
	 * numberOfOutputs) { String methodCall = ""; if (numberOfOutputs > 0) {
	 * methodCall = methodCall + "let ("; int i = 1; while(i < numberOfOutputs)
	 * { methodCall = methodCall + "r" + Integer.toString(i) + ", "; i++; }
	 * methodCall = methodCall + "r" + Integer.toString(i) + ")= "; }
	 * 
	 * StringBuilder fileBuilder = new StringBuilder(methodName); int index =
	 * fileBuilder.length(); //fileBuiler //methodCall = methodCall + return
	 * methodCall;
	 * 
	 * }
	 * 
	 * /* NOT IN USE private static String getUsingDeclaration(String
	 * numberOfQubits) { return "\t" + "(register[" + numberOfQubits + "]) {" +
	 * System.lineSeparator(); }
	 */

	/*
	 * NOT IN USE private static int getNumberOfOutputs(String outputType) { int
	 * lastIndex = 0; int count = 0; if (outputType.contains("Unit")) { return
	 * 0; } else { while(lastIndex != -1){ lastIndex =
	 * outputType.indexOf(",",lastIndex); if(lastIndex != -1){ count ++;
	 * lastIndex += 1; } } return count + 1; }
	 * 
	 * }
	 */
}
