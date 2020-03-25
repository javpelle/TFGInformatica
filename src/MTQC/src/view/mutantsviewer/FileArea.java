package view.mutantsviewer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.mutant.Mutant;
import view.tools.TextField;

public class FileArea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea originalArea;

	private JTextArea mutantArea;

	private TextField line;

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
		line = new TextField("Line...");
		add(line, BorderLayout.NORTH);
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

	public void updateMutant(Mutant mutant) {
		line.setText("Line " + mutant.getLineChanged());
		originalArea.setText(readFile(mutant.getOriginalCompletePath()));
		mutantArea.setText(readFile(mutant.getMutantCompletePath()));
	}

	private String readFile(String file) {
		int lineCounter = 1;
		String aux = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			while (line != null) {
				aux = aux + lineCounter + "\t" + line + System.lineSeparator();
				line = reader.readLine();
				++lineCounter;
			}
			reader.close();
		} catch (Exception e) {
			JFrame error = new JFrame();
			JOptionPane.showMessageDialog(error, e.getMessage());
		}
		return aux;
	}

}
