package view.mutantsviewer;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.tools.TextField;

public class FileArea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea originalArea;

	private JTextArea mutantArea;

	public FileArea() {
		setLayout(new BorderLayout());

		createNorthPanel();

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 1));
		center.add(createOriginal());
		center.add(createMutant());
		add(center, BorderLayout.CENTER);

	}

	private void createNorthPanel() {
		add(new TextField("Line..."), BorderLayout.NORTH);
	}

	private JPanel createOriginal() {
		JPanel original = new JPanel();
		original.setLayout(new BorderLayout());
		originalArea = new JTextArea();
		originalArea.setEditable(false);
		original.setBorder(BorderFactory.createTitledBorder("Original"));
		original.add(new JScrollPane(originalArea), BorderLayout.CENTER);
		return original;
	}

	private JPanel createMutant() {
		JPanel mutant = new JPanel();
		mutant.setLayout(new BorderLayout());
		mutantArea = new JTextArea();
		mutantArea.setEditable(false);
		mutant.setBorder(BorderFactory.createTitledBorder("Mutant"));
		mutant.add(new JScrollPane(mutantArea), BorderLayout.CENTER);
		return mutant;
	}

}
