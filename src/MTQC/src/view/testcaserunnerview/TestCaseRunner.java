/**
 * This code is part of MTQC.
 * 
 * Copyright (c) 2020 Javier Pellejero, Luis Aguirre.
 * 
 * This code is licensed under the MIT License. You may obtain a copy 
 * of this license in the LICENSE file in the root directory of this source tree 
 * or at https://github.com/javpelle/TFGInformatica/blob/master/LICENSE.
 */
package view.testcaserunnerview;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.mutant.Mutant;
import model.test.Test;
import view.testcaserunnerview.RunOptions.FileComboListener;
import view.tools.LogArea;

/**
 * Tab used to show all available parameters for running test on previously
 * generated mutants.
 * 
 * @author Javier & Luis.
 *
 */
public class TestCaseRunner extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton runTests;

	private MutantsView mutantsView;

	private RunOptions runOptions;

	private InputTest inputTest;

	private LogArea log;
	/**
	 * Constructor for the class.
	 * @param listenerCombo Listener for the selected file field.
	 * @param listenerRun Listener for the run button.
	 */
	public TestCaseRunner(FileComboListener listenerCombo, RunListener listenerRun) {
		setLayout(new BorderLayout());

		mutantsView = new MutantsView();
		log = new LogArea();

		JPanel west = new JPanel(new GridLayout(2, 1));
		JPanel westAux = new JPanel(new BorderLayout());
		westAux.setBorder(BorderFactory.createTitledBorder("Log"));
		westAux.add(new JScrollPane(log));
		west.add(mutantsView);
		west.add(westAux);
		add(west, BorderLayout.WEST);

		runOptions = new RunOptions(listenerCombo);
		inputTest = new InputTest();

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(runOptions, BorderLayout.NORTH);
		center.add(inputTest, BorderLayout.CENTER);

		add(center, BorderLayout.CENTER);

		runTests = new JButton("Run Tests");
		runTests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listenerRun.runTests(mutantsView.getSelectedFiles(), runOptions.getFileName(),
						runOptions.getMethodName(), runOptions.getTestType(), runOptions.getShots(),
						inputTest.getTest(), runOptions.getTimeLimit());
			}
		});
		JPanel south = new JPanel();
		south.add(runTests);
		add(south, BorderLayout.SOUTH);
	}
	
	/**
	 * Updates the available mutants for the selected file.
	 * @param mutants List of available mutants.
	 * @param fileName Name of the selected file.
	 */
	public void updateMutants(ArrayList<Mutant> mutants) {
		mutantsView.updateMutants(mutants);
	}
	/**
	 * Updates the language selection.
	 * @param qiskit Boolean which indicates if qiskit is selected.
	 */
	public void updateLanguage(boolean qiskit) {
		inputTest.updateLanguage(qiskit);
	}
	
	/**
	 * Refreshes the available files in the file field.
	 * @param files List of available files.
	 */
	public void refreshFileCombo(ArrayList<String> files) {
		runOptions.refreshFileCombo(files);
	}
	/**
	 * Refreshes the methods in the method field.
	 * @param fileMethods List of methods declared inside the selected file.
	 */
	public void updateFileMethods(ArrayList<String> fileMethods) {
		runOptions.updateFileMethods(fileMethods);

	}
	/**
	 * Shows available test types.
	 * @param tests List of all types of test.
	 */
	public void setTests(Test[] tests) {
		runOptions.setTests(tests);
	}
	
	/**
	 * Interface Listener for run button.
	 * @author Javier & Luis.
	 *
	 */
	public interface RunListener {
		public void runTests(ArrayList<Mutant> selectedMutants, String fileName, String methodName, Test testType,
				int shots, ArrayList<String> testList, double timeLimit);
	}
	/**
	 * Notifies a message to the log screen.
	 * @param msg Message notified.
	 */
	public void notify(String msg) {
		log.setMessage(msg);
	}
}