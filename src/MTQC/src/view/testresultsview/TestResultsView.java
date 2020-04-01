package view.testresultsview;

import javax.swing.JPanel;
import view.tools.TabbedResultTable;
public class TestResultsView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TabbedResultTable table;
	
	public TestResultsView() {
		table = new TabbedResultTable();
	}

}
