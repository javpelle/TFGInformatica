package view.testcaserunner;

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
import view.testcaserunner.RunOptions.FileComboListener;
import view.tools.LogArea;

public class TestCaseRunner extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton runTests;

	private MutantsView mutantsView;

	private RunOptions runOptions;

	private InputTest inputTest;
	
	private LogArea log;

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

	public void updateMutants(ArrayList<Mutant> mutants, String fileName) {
		mutantsView.updateMutants(mutants, fileName);
	}

	public void updateLanguage(boolean qiskit) {
		inputTest.updateLanguage(qiskit);
	}

	public void refreshFileCombo(ArrayList<String> files) {
		runOptions.refreshFileCombo(files);
	}

	public void updateFileMethods(ArrayList<String> fileMethods) {
		runOptions.updateFileMethods(fileMethods);

	}

	public void setTests(Test[] tests) {
		runOptions.setTests(tests);
	}

	public interface RunListener {
		public void runTests(ArrayList<Mutant> selectedMutants, String fileName, String methodName, Test testType,
				int shots, ArrayList<String> testList, double timeLimit);
	}

	public void notify(String msg) {
		log.setMessage(msg);		
	}
}
