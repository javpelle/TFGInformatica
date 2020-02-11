package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import view.mutantgeneratorview.MutantsGenerator;
import view.mutantsviewer.MutantsViewer;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private MutantsGenerator mutantsgenerator;

	public TabbedPane() {
		mutantsgenerator = new MutantsGenerator();
		addTab("Mutants Generator", mutantsgenerator);

		JPanel mutantsViewer = new MutantsViewer();
		addTab("Mutants Viewer", mutantsViewer);

		JPanel panel3 = new JPanel();
		addTab("TestCase Runner", panel3);

	}

}
