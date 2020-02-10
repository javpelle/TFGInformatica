package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import view.mutantgeneratorview.MutantsGenerator;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private MutantsGenerator mutantsgenerator;

	public TabbedPane() {
		mutantsgenerator = new MutantsGenerator();
		addTab("Mutants Generator", mutantsgenerator);

		JPanel panel2 = new JPanel();
		addTab("Mutants Viewer", panel2);

		JPanel panel3 = new JPanel();
		addTab("TestCase Runner", panel3);

	}

}
