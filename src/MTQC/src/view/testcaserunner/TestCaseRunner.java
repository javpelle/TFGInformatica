package view.testcaserunner;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.mutant.Mutant;
import view.testcaserunner.RunOptions.FileComboListener;
import view.testcaserunner.RunOptions.SpinnerListener;

public class TestCaseRunner extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MutantsView mutantsView;

	private RunOptions runOptions;

	public TestCaseRunner(FileComboListener listenerCombo, SpinnerListener listenerSpinner) {
		setLayout(new BorderLayout());

		mutantsView = new MutantsView();

		add(mutantsView, BorderLayout.WEST);

		runOptions = new RunOptions(listenerCombo, listenerSpinner);

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.add(runOptions, BorderLayout.NORTH);
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
}
