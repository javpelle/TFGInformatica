package view.tools;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import model.testresult.TestResult;

public class TabbedResultTable extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<ResultTable> tabs;

	public TabbedResultTable() {
		tabs = new ArrayList<ResultTable>();
	}

	public void newWindow() {
		JPanel aux = new JPanel(new BorderLayout());
		//ResultTable auxWindow = new ResultTable();
		//tabs.add(auxWindow);
		//aux.add(new JScrollPane(auxWindow), BorderLayout.CENTER);
		addTab("Test " + String.valueOf(tabs.size()), aux);
		setSelectedIndex(tabs.size() - 1);
	}
	
	public void setTabs(int nTests){
		for (int i = 0; i < nTests; i++){
			newWindow();
		}
	}
	
	public void addResults(ArrayList<ArrayList<TestResult>> results){
		//
	}
	
	public void removeWindow() {
		if (tabs.size() > 1) {
			int index = getSelectedIndex();
			remove(index);
			tabs.remove(index);
			updateIndex();
		}
	}

	private void updateIndex() {
		for (int i = 0; i < tabs.size(); i++) {
			this.setTitleAt(i, String.valueOf(i + 1));
		}
	}
}
