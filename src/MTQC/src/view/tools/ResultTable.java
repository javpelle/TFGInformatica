package view.tools;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ResultTable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> results;
	private ArrayList<String> names;
	private TextField[][] labels;

	public ResultTable(ArrayList<String> results, ArrayList<String> names) {
		this.results = results;
		this.names = names;
		setLayout(new GridLayout(results.size(), 3));
		labels = new TextField[results.size()][3];
		init();
	}

	private void init() {
		for (int i = 0; i < results.size(); i++) {
			labels[i][0] = new TextField(names.get(i));
			labels[i][1] = new TextField(results.get(i));
			labels[i][2] = new TextField("");
			add(labels[i][0]);
			add(labels[i][1]);
			add(labels[i][2]);
		}
	}
}
