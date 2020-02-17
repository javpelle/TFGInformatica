package view;

import java.util.ArrayList;

import javax.swing.JTabbedPane;

import model.mutant.Mutant;
import model.mutantoperator.MutantOperator;
import view.mutantgeneratorview.MutantsGenerator;
import view.mutantgeneratorview.Files.NewPathListener;
import view.mutantgeneratorview.MutantsGenerator.NewGenerateListener;
import view.mutantsviewer.MutantsViewer;
import view.testcaserunner.TestCaseRunner;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private MutantsGenerator mutantsgenerator;

	private MutantsViewer mutantsViewer;
	
	private TestCaseRunner testCaseRunner;

	public TabbedPane(NewPathListener listener, NewGenerateListener listenGenerate) {
		mutantsgenerator = new MutantsGenerator(listener, listenGenerate);
		addTab("Mutants Generator", mutantsgenerator);

		mutantsViewer = new MutantsViewer();
		addTab("Mutants Viewer", mutantsViewer);

		testCaseRunner = new TestCaseRunner();
		addTab("TestCase Runner", testCaseRunner);

	}

	public void updatePath(ArrayList<String> files) {
		mutantsgenerator.updatePath(files);
	}

	public void updateOperators(MutantOperator[] mutantOperatorList) {
		mutantsgenerator.updateOperators(mutantOperatorList);
	}

	public void updateMutants(ArrayList<Mutant> mutantList) {
		mutantsViewer.updateMutants(mutantList);
	}

}
