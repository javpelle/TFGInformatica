package view.tools;

import javax.swing.JTable;

public class JTableCheck extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTableCheck(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int column) {
		switch (column) {
		case 0:
			return Boolean.class;
		default:
			return String.class;
		}
	}

	public boolean isCellEditable(int row, int column) {
		return column == 0;
	}

}
