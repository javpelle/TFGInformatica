package view.testcaserunner;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.tools.InputTable;

public class InputTableView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int defaultNumQBits = 3;

	private InputTable table;

	private JButton setQBits;

	private JButton addRow;

	private JButton removeRow;

	private JButton addColumn;

	private JButton removeColumn;
	
	private JButton selectFile;

	private JSpinner numQBits;
	
	private JFileChooser fileChooser;
	
	private  JTextArea filePath;

	public InputTableView() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Inputs"));
		
		createCenterPanel();
		createNorthPanel();
		
	}


	public void updateLanguage(boolean qiskit) {
		table.updateLanguage(qiskit);		
	}
	
	private void createCenterPanel() {
		
		JPanel aux = new JPanel(new BorderLayout());
		aux.setLayout(new BorderLayout());
		aux.setBorder(BorderFactory.createTitledBorder("Manual Test Inputs"));
		table = new InputTable(defaultNumQBits);
		aux.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel grid = new JPanel(new GridLayout());
		grid.setLayout(new GridLayout(4, 2));

		numQBits = new JSpinner(new SpinnerNumberModel(defaultNumQBits, 1, 10000, 1));
		grid.add(numQBits);

		setQBits = new JButton("Set QBits");
		setQBits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.insertQuantumStates((int) numQBits.getValue());
			}
		});
		grid.add(setQBits);

		addRow = new JButton("Add Row");
		addRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.addRow();
			}
		});
		grid.add(addRow);

		removeRow = new JButton("Remove Row");
		grid.add(removeRow);

		addColumn = new JButton("Add Column");
		grid.add(addColumn);

		removeColumn = new JButton("Remove Column");
		grid.add(removeColumn);
		
		aux.add(grid, BorderLayout.SOUTH);
		
		add(aux, BorderLayout.CENTER);
		
	}

	private void createNorthPanel() {
		JPanel aux = new JPanel(new BorderLayout());
		aux.setLayout(new BorderLayout());
		aux.setBorder(BorderFactory.createTitledBorder("Test File Selection"));
		
		filePath = new JTextArea(System.getProperty("user.dir"));
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


	protected void updateFileSelection(File selectedFile) {
		filePath.setText(selectedFile.getAbsolutePath());
	}


	public String getTestFileName() {
		return filePath.getText();
	}
}
