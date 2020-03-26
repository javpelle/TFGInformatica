package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Model;
import model.mutant.Mutant;
import model.mutantoperator.MutantOperator;
import model.test.Test;

public class Controller {

	private Model model;
	private static final String testTokenSeparator = "***";

	public Controller(Model model) {
		this.model = model;
	}

	public void start() {
		model.start();
	}
	
	public void reset() {
		model.reset();
	}

	public void updatePath(String path) {
		model.updatePath(path);
	}

	public void updateLanguage(boolean qiskit) {
		model.updateMutantOperators(qiskit);
	}

	public void generate(ArrayList<String> files, ArrayList<MutantOperator> operators) {
		model.generate(files, operators);

	}

	public void removeMutants() {
		model.removeMutants();
	}

	public void refreshPath() {
		model.refreshPath();
	}

	public void getFileMethods(String fileName) {
		model.getFileMethods(fileName);

	}

	public void updateTimeLimit(double timeLimit) {
		model.setTimeLimit(timeLimit);
	}

	public void runTests(ArrayList<Mutant> selectedMutants, String fileName, String methodName, Test testType,
			int shots, ArrayList<String> testList, double timeLimit) {
		ArrayList<String> testSuite;
		String file = testList.get(testList.size() - 1);
		if (!file.equals("")) {
			testSuite = setTestFromFile(file);
		} else {
			testList.remove(testList.size() - 1);
			testSuite = testList;
		}
		testType.setShots(shots);
		model.run(selectedMutants, testSuite, testType, fileName, methodName, timeLimit);
	}

	private ArrayList<String> setTestFromFile(String testFileName) {
		File file = new File(testFileName);
		ArrayList<String> testSuite = new ArrayList<String>();
		BufferedReader reader = null;
		String testString = "";

		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {

				if (line.equals(testTokenSeparator)) {
					testSuite.add(testString);
					testString = "";

				} else {
					testString = testString + line + System.lineSeparator();
				}

				line = reader.readLine();
			}

		} catch (IOException e) {
			model.notifyError(e);

		} finally {
			try {
				reader.close();

			} catch (IOException e) {
				model.notifyError(e);
			}
		}
		return testSuite;
	}

}
