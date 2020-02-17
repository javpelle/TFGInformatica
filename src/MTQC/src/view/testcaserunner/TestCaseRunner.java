package view.testcaserunner;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.mutant.Mutant;

public class TestCaseRunner extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MutantsView mutantsView;

	public TestCaseRunner() {
		setLayout(new BorderLayout());

		mutantsView = new MutantsView();

		add(mutantsView, BorderLayout.WEST);
	}
	
	public void updateMutants(ArrayList<Mutant> mutants) {
		mutantsView.updateMutants(mutants);
	}

}
