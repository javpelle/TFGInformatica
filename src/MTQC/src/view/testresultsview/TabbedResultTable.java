package view.testresultsview;

import java.util.ArrayList;

import javax.swing.JTabbedPane;
import model.testresult.TestResult;
import view.tools.ResultTable;

public class TabbedResultTable extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<ResultTable> tabs;

	public TabbedResultTable() {
		tabs = new ArrayList<ResultTable>();
		
	}

	public void update(ArrayList<ArrayList<TestResult>> results) {
		deleteAll();
		for (ArrayList<TestResult> t : results) {
			ResultTable aux = new ResultTable(t);
			tabs.add(aux);
			addTab("Test " + String.valueOf(tabs.size()), aux);
		}
	}

	private void deleteAll() {
		tabs.clear();
		this.removeAll();
	}

	public void updateKills(ArrayList<ArrayList<Boolean>> kills) {
	
		for (int i = 0; i < kills.size(); i++) {
			tabs.get(i).updateKills(kills.get(i));
		}
	}

}
