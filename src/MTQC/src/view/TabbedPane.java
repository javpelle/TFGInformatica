package view;

import java.util.ArrayList;

import javax.swing.JTabbedPane;

import model.mutant.Mutant;
import model.mutantoperator.MutantOperator;
import model.test.Test;
import model.testresult.TestResult;
import view.mutantgeneratorview.MutantsGenerator;
import view.mutantgeneratorview.Files.NewPathListener;
import view.mutantgeneratorview.MutantsGenerator.NewGenerateListener;
import view.mutantsviewer.MutantsViewer;
import view.testcaserunner.TestCaseRunner;
import view.testcaserunner.TestCaseRunner.RunListener;
import view.testresultsview.TestResultsView;
import view.testresultsview.TestResultsView.ConfidenceListener;
import view.testcaserunner.RunOptions.FileComboListener;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private MutantsGenerator mutantsgenerator;

	private MutantsViewer mutantsViewer;

	private TestCaseRunner testCaseRunner;

	private TestResultsView testResults;

	public TabbedPane(NewPathListener listener, NewGenerateListener listenGenerate, FileComboListener listenerComboFile,
			RunListener listenerRun, ConfidenceListener listenerConfidence) {
		mutantsgenerator = new MutantsGenerator(listener, listenGenerate);
		addTab("Mutants Generator", mutantsgenerator);

		mutantsViewer = new MutantsViewer();
		addTab("Mutants Viewer", mutantsViewer);

		testCaseRunner = new TestCaseRunner(listenerComboFile, listenerRun);
		addTab("TestCase Runner", testCaseRunner);

		testResults = new TestResultsView(listenerConfidence);
		addTab("Test Results", testResults);

	}

	public void updatePath(ArrayList<String> files) {
		mutantsgenerator.updatePath(files);
		testCaseRunner.refreshFileCombo(files);
	}

	public void updateOperators(MutantOperator[] mutantOperatorList, boolean qiskit) {
		mutantsgenerator.updateOperators(mutantOperatorList);
		testCaseRunner.updateLanguage(qiskit);
	}

	public void updateMutants(ArrayList<Mutant> mutantList) {
		mutantsViewer.updateMutants(mutantList);
	}

	public void updateFileMethods(ArrayList<String> fileMethods, ArrayList<Mutant> mutants, String fileName) {
		testCaseRunner.updateFileMethods(fileMethods);
		testCaseRunner.updateMutants(mutants, fileName);
	}

	public void setTests(Test[] tests) {
		testCaseRunner.setTests(tests);
	}

	public void notifyMutantsGenerator(String msg) {
		mutantsgenerator.notify(msg);
	}

	public void notifyTestCaseRunner(String msg) {
		testCaseRunner.notify(msg);	
	}

	public void notifyResults(ArrayList<ArrayList<TestResult>> results) {
		testResults.update(results);		
	}

	public void updateKills(ArrayList<ArrayList<Boolean>> kills) {
		testResults.updateKills(kills);
	}

}
