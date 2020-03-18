package view.testcaserunner;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.tools.TabbedTextArea;

public class InputTest extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFileChooser fileChooser;

	private JTextArea filePath;

	private JButton selectFile;

	private TabbedTextArea inputTest;

	private JButton newTest;

	private JButton removeTest;

	public InputTest() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Inputs"));

		createCenterPanel();
		createNorthPanel();

	}

	private void createCenterPanel() {

		JPanel center = new JPanel(new BorderLayout());
		center.setBorder(BorderFactory.createTitledBorder("Manual Test Inputs"));

		inputTest = new TabbedTextArea();
		center.add(new JScrollPane(inputTest), BorderLayout.CENTER);

		// Added center panel
		add(center, BorderLayout.CENTER);

		JPanel south = new JPanel(new GridLayout(1, 2));

		newTest = new JButton("New test");
		newTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTest.newWindow();
			}
		});
		south.add(newTest);
		
		removeTest = new JButton("Remove test");
		removeTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTest.removeWindow();
			}
		});
		south.add(removeTest);
		add(south, BorderLayout.SOUTH);
		

	}

	private void createNorthPanel() {
		JPanel aux = new JPanel(new BorderLayout());
		aux.setLayout(new BorderLayout());
		aux.setBorder(BorderFactory.createTitledBorder("Test File Selection"));

		filePath = new JTextArea();
		aux.add(new JScrollPane(filePath), BorderLayout.CENTER);

		fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt*", "txt");
		fileChooser.addChoosableFileFilter(filter);

		selectFile = new JButton("Select Test File");
		selectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showDialog(null, "Seleccionar");
				if (result == JFileChooser.APPROVE_OPTION) {
					updateFileSelection(fileChooser.getSelectedFile());
				}
			}
		});
		aux.add(selectFile, BorderLayout.EAST);

		add(aux, BorderLayout.NORTH);

	}

	/**
	 * 
	 * @param selectedFile
	 */
	private void updateFileSelection(File selectedFile) {
		filePath.setText(selectedFile.getAbsolutePath());
	}
	
	public void updateLanguage(boolean qiskit) {
		inputTest.updateLanguage(qiskit);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getTest() {
		ArrayList<String> list = inputTest.getTests();
		list.add(filePath.getText());
		return list;
	}
}
