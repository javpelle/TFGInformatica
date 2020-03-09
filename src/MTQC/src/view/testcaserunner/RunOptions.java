package view.testcaserunner;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

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

	public RunOptions(FileComboListener listener) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		fileCombo(listener);
		methodCombo();
		timeLimit();
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
				//System.out.println((String) files.getSelectedItem());
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
	public interface FileComboListener {
		public void refreshPath();
		public void refreshMethods(String fileName);
	}
	
	public void refreshFileCombo(ArrayList<String> files){
		this.files.removeAllItems();
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
}
