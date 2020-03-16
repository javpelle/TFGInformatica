package view;

import java.util.ArrayList;

import javax.swing.JTabbedPane;

import model.mutant.Mutant;
import model.mutantoperator.MutantOperator;
import model.test.Test;
import view.mutantgeneratorview.MutantsGenerator;
import view.mutantgeneratorview.Files.NewPathListener;
import view.mutantgeneratorview.MutantsGenerator.NewGenerateListener;
import view.mutantsviewer.MutantsViewer;
import view.testcaserunner.TestCaseRunner;
import view.testcaserunner.TestCaseRunner.RunListener;
import view.testcaserunner.RunOptions.FileComboListener;
import view.testcaserunner.RunOptions.SpinnerListener;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private MutantsGenerator mutantsgenerator;

	private MutantsViewer mutantsViewer;

	private TestCaseRunner testCaseRunner;

	public TabbedPane(NewPathListener listener, NewGenerateListener listenGenerate, FileComboListener listenerComboFile,
			SpinnerListener listenerSpinner, RunListener listenerRun) {
		mutantsgenerator = new MutantsGenerator(listener, listenGenerate);
		addTab("Mutants Generator", mutantsgenerator);

		mutantsViewer = new MutantsViewer();
		addTab("Mutants Viewer", mutantsViewer);

		testCaseRunner = new TestCaseRunner(listenerComboFile, listenerSpinner, listenerRun);
		addTab("TestCase Runner", testCaseRunner);

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
		testCaseRunner.updateMutants(mutantList);
	}

	public void updateFileMethods(ArrayList<String> fileMethods) {
		testCaseRunner.updateFileMethods(fileMethods);

	}

	public void setTests(Test[] tests) {
		testCaseRunner.setTests(tests);		
	}

}
