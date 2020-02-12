package view.tools;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableCheck extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DefaultTableModel model;

	public JTableCheck(Object[] columnNames) {
		super(new DefaultTableModel(new Object[1][2], columnNames));
		model = (DefaultTableModel) getModel();
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

	public void addRow(Object[] o) {
		model.addRow(o);
	}

	public void clear() {
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
		}
	}

	public void setAllTrue() {
		if (model.getRowCount() > 0) {
			for (int i = 0; i < model.getRowCount(); ++i) {
				model.setValueAt(true, i, 0);
			}
		}
	}

	public void setAllFalse() {
		if (model.getRowCount() > 0) {
			for (int i = 0; i < model.getRowCount(); ++i) {
				model.setValueAt(false, i, 0);
			}
		}
	}

}
