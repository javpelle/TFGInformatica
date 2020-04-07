/**
 * This code is part of MTQC.
 * 
 * Copyright (c) 2020 Javier Pellejero, Luis Aguirre.
 * 
 * This code is licensed under the MIT License. You may obtain a copy 
 * of this license in the LICENSE file in the root directory of this source tree 
 * or at https://github.com/javpelle/TFGInformatica/blob/master/LICENSE.
 */

package model.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import files.TestFile;
import model.test.ProbabilityTest;
import model.test.Test;
import model.testresult.TestResult;

/**
 * Language concrete class, which overrides some methods in order to implement
 * the well behavior for QSharp language.
 * 
 * @author Javier & Luis
 *
 */
public class QSharp extends Language {
	/**
	 * Name for the initialization method.
	 */
	private static final String method = "MainQuantum";

	/**
	 * Token used to get the lines which contains amplitudes on a Probability Test
	 */
	private static final String probabilsiticKey = "∣";

	@Override
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

	/**
	 * Changes the name space of a QSharp file.
	 * 
	 * @param file          Name of the file.
	 * @param namespaceName Name of the new namespace.
	 * @return String which contains the declaration of the namespace.
	 */
	private static String changeNamespace(String file, String namespaceName) {
		int ini = file.indexOf("namespace ");
		int end = file.indexOf("{", ini);
		return file.substring(0, ini) + "namespace " + namespaceName + file.substring(end);
	}

	/**
	 * Dynamically generates main method on QSharp used to initialize qubits and
	 * calling tested method,
	 * 
	 * @param methodName Name of the method to be tested.
	 * @param testInput  Test to be implemented.
	 * @return String which contains the declaration of main method.
	 */
	private static String getMainMethod(String methodName, String testInput) {
		String outputType = getOutputType(methodName);
		return getMainHeader() + outputType + "{" + System.lineSeparator() + tabString(testInput)
				+ System.lineSeparator() + "}" + System.lineSeparator();

	}

	/**
	 * Return the method return type.
	 * 
	 * @param methodName Name of the method.
	 * @return String which contains the type of the method output.
	 */
	private static String getOutputType(String methodName) {
		int index = methodName.lastIndexOf(":", methodName.length());
		return methodName.substring(index);
	}

	/**
	 * Get the header of main method on QSharp.
	 * 
	 * @return String which containts the header of main method.
	 */
	private static String getMainHeader() {
		return "operation MainQuantum() ";
	}

	/**
	 * Given a String, the method tabs after each line break.
	 * 
	 * @param input String to be tabbed.
	 * @return The initial String with a new tab character after each line break.
	 */
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
	protected String isProbQsharp(Test test) {
		if (test instanceof ProbabilityTest) {
			return ", probQSharp=True";
		} else {
			return "";
		}
	}

	@Override
	protected String getMethodCall(String file) {
		return file + "." + method + ".simulate";
	}

	@Override
	protected ArrayList<ArrayList<TestResult>> generateResults(BufferedReader in, ArrayList<ArrayList<TestFile>> files,
			Test test) {
		boolean isProbabilistic = test instanceof ProbabilityTest;
		BufferedReader reader = null;
		if (isProbabilistic) {
			File resultFile = new File(path + File.separator + probabilisticQsharpResultFile);
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(resultFile), "UTF8"));
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
			}
		}
		ArrayList<ArrayList<TestResult>> results = new ArrayList<ArrayList<TestResult>>();
		for (ArrayList<TestFile> list : files) {
			ArrayList<TestResult> aux = new ArrayList<TestResult>();
			for (int t = 0; t < list.size(); t++) {
				TestResult tr = test.newTestResult(list.get(t).getMutantName(), list.get(t).getIdTest());
				for (int i = 0; i < test.getShots(); i++) {
					if (isProbabilistic) {
						tr.setResult(readLineProbabilistic(reader));
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

	/**
	 * Reads the probabilities of a quantum state. Used for Probability type of
	 * test.
	 * 
	 * @param reader Reader used to read from standar output.
	 * @return A String which contains the probabilities for each posible quantum
	 *         state.
	 */
	private String readLineProbabilistic(BufferedReader reader) {
		String result = "";
		try {
			String line = reader.readLine();
			while (line != null && !line.startsWith(probabilsiticKey)) {
				line = reader.readLine();
			}
			if (line != null) {
				do {
					result = result + line.substring(line.indexOf("["), line.indexOf("]") + 1);
					line = reader.readLine();
				} while (line != null && line.startsWith(probabilsiticKey));
			} else {
				reader.close();
			}
		} catch (IOException e) {
		}

		return result;
	}
}
