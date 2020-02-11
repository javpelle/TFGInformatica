package view.mutantsviewer;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.mutant.Mutant;

public class MutantsViewer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JList<Mutant> mutantList;

	private FileArea fileArea;

	public MutantsViewer() {
		setLayout(new BorderLayout());

		createWestPanel();

		fileArea = new FileArea();
		add(fileArea, BorderLayout.CENTER);

	}

	private void createWestPanel() {
		JPanel west = new JPanel();
		west.setBorder(BorderFactory.createTitledBorder("Mutants"));
		west.setLayout(new BorderLayout());
		Mutant exampleList[] = { new Mutant("EXAMPLE1", "FileO", "FileM", 0) };
		mutantList = new JList<Mutant>(exampleList);
		west.add(new JScrollPane(mutantList), BorderLayout.CENTER);
		add(west, BorderLayout.WEST);
	}

}
