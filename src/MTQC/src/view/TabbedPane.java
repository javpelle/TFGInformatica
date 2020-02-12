package view;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import view.mutantgeneratorview.MutantsGenerator;
import view.mutantgeneratorview.Files.NewPathListener;
import view.mutantsviewer.MutantsViewer;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private MutantsGenerator mutantsgenerator;

	private MutantsViewer mutantsViewer;

	public TabbedPane(NewPathListener listener) {
		mutantsgenerator = new MutantsGenerator(listener);
		addTab("Mutants Generator", mutantsgenerator);

		mutantsViewer = new MutantsViewer();
		addTab("Mutants Viewer", mutantsViewer);

		JPanel panel3 = new JPanel();
		addTab("TestCase Runner", panel3);

	}

	public void updatePath(ArrayList<String> files) {
		mutantsgenerator.updatePath(files);
	}

}
