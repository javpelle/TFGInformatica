package view.testcaserunner;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import view.tools.TextField;

public class RunOptions extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JComboBox<String> files;

	private JComboBox<String> methods;

	private JSpinner spinner;

	private JButton timeSet;

	public RunOptions() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		fileCombo();
		methodCombo();
		timeLimit();
	}

	private void fileCombo() {
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1, 2));
		aux.add(new TextField("File:"));
		files = new JComboBox<String>();
		aux.add(files);
		add(aux);
	}

	private void methodCombo() {
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1, 2));
		aux.add(new TextField("Method:"));
		methods = new JComboBox<String>();
		aux.add(methods);
		add(aux);
	}

	private void timeLimit() {
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1, 3));
		aux.add(new TextField("Time Limt:"));
		spinner = new JSpinner(new SpinnerNumberModel(3.0, 0.1, 100.0, 0.1));
		aux.add(spinner);
		timeSet = new JButton("Set time");
		aux.add(timeSet);
		add(aux);
	}

}
