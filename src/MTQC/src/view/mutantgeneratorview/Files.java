package view.mutantgeneratorview;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.tools.JTableCheck;

public class Files extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTableCheck table;

	public Files() {
		Object[][] data = { { false, "Operator1" }, { false, "Operator2" } };

		Object[] column = { "", "File" };
		table = new JTableCheck(data, column);

		add(new JScrollPane(table));
	}

}
