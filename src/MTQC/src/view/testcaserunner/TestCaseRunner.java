package view.testcaserunner;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.mutant.Mutant;
import model.test.Test;
import view.testcaserunner.RunOptions.FileComboListener;
import view.testcaserunner.RunOptions.SpinnerListener;

public class TestCaseRunner extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MutantsView mutantsView;

	private RunOptions runOptions;

	private InputTableView tableView;

	public TestCaseRunner(FileComboListener listenerCombo, SpinnerListener listenerSpinner) {
		setLayout(new BorderLayout());

		mutantsView = new MutantsView();

		add(mutantsView, BorderLayout.WEST);

		runOptions = new RunOptions(listenerCombo, listenerSpinner);
		tableView = new InputTableView();

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(runOptions, BorderLayout.NORTH);
		center.add(tableView, BorderLayout.CENTER);

		add(center, BorderLayout.CENTER);
	}

	public void updateMutants(ArrayList<Mutant> mutants) {
		mutantsView.updateMutants(mutants);
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
}
