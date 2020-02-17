package view;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.mutant.Mutant;
import model.mutantoperator.MutantOperator;
import view.mutantgeneratorview.MutantsGenerator;
import view.mutantgeneratorview.Files.NewPathListener;
import view.mutantgeneratorview.MutantsGenerator.NewGenerateListener;
import view.mutantsviewer.MutantsViewer;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private MutantsGenerator mutantsgenerator;

	private MutantsViewer mutantsViewer;

	public TabbedPane(NewPathListener listener, NewGenerateListener listenGenerate) {
		mutantsgenerator = new MutantsGenerator(listener, listenGenerate);
		addTab("Mutants Generator", mutantsgenerator);

		mutantsViewer = new MutantsViewer();
		addTab("Mutants Viewer", mutantsViewer);

		JPanel panel3 = new JPanel();
		addTab("TestCase Runner", panel3);

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
