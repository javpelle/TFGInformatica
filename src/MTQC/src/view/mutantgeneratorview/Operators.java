package view.mutantgeneratorview;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.tools.JTableCheck;

public class Operators extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTableCheck table;

	public Operators() {
		Object[][] data = { { false, "Operator1" }, { false, "Operator2" } };

		Object[] column = { "", "Operator" };
		table = new JTableCheck(data, column);
		add(new JScrollPane(table));
	}

}
