package view.testcaserunner;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import model.test.Test;
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

	private JComboBox<Test> testType;

	private JSpinner shots;

	public RunOptions(FileComboListener listenerCombo, SpinnerListener listenerSpinner) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		fileCombo(listenerCombo);
		methodCombo();
		timeLimit(listenerSpinner);
		testType();
	}

	private void fileCombo(FileComboListener listener) {
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1, 2));
		aux.add(new TextField("File:"));
		files = new JComboBox<String>();
		files.addPopupMenuListener(new PopupMenuListener() {

			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				if (files.getSelectedItem() != null) {
					listener.refreshMethods((String) files.getSelectedItem());
				}
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				listener.refreshPath();
			}
		});
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

	private void timeLimit(SpinnerListener listener) {
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1, 3));
		aux.add(new TextField("Time Limt:"));
		spinner = new JSpinner(new SpinnerNumberModel(3.0, 0.1, 100.0, 0.1));
		aux.add(spinner);
		timeSet = new JButton("Set time");
		timeSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.updateTime((double) spinner.getValue());
			}
		});
		aux.add(timeSet);
		add(aux);
	}

	public void testType() {
		JPanel aux1 = new JPanel();
		aux1.setLayout(new GridLayout(1, 2));
		aux1.add(new TextField("Test Type:"));
		testType = new JComboBox<Test>();
		aux1.add(testType);
		JPanel aux2 = new JPanel();
		aux2.setLayout(new GridLayout(1, 2));
		aux2.add(new TextField("Shots:"));
		shots = new JSpinner(new SpinnerNumberModel(10, 1, 10000, 1));
		shots.setEnabled(false);
		aux2.add(shots);
		testType.addPopupMenuListener(new PopupMenuListener() {

			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				if (testType.getSelectedIndex() == 0) {
					shots.setEnabled(false);
				} else {
					shots.setEnabled(true);
				}
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		add(aux1);
		add(aux2);
	}

	public void refreshFileCombo(ArrayList<String> files) {
		this.files.removeAllItems();
		this.files.addItem(null);
		for (int i = 0; i < files.size(); i++) {
			this.files.addItem(files.get(i));
		}
	}

	public void updateFileMethods(ArrayList<String> fileMethods) {
		this.methods.removeAllItems();
		for (int i = 0; i < fileMethods.size(); i++) {
			this.methods.addItem(fileMethods.get(i));
		}

	}

	public interface FileComboListener {
		public void refreshPath();

		public void refreshMethods(String fileName);
	}

	public interface SpinnerListener {
		public void updateTime(double timeLimit);
	}

	public Test getTestType() {
		return (Test) testType.getSelectedItem();
	}

	public int getShots() {
		return (int) shots.getValue();
	}

	public void setTests(Test[] tests) {
		for (Test t : tests) {
			testType.addItem(t);
		}
	}

	public String getMethodName() {
		return methods.getSelectedItem().toString();
	}

	public String getFileName() {
		return files.getSelectedItem().toString();
	}

}
