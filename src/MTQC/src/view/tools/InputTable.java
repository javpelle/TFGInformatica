package view.tools;

import javax.swing.JTable;

public class InputTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MyDefaultTableModel model;

	public InputTable() {
		super(new MyDefaultTableModel());
		model = (MyDefaultTableModel) getModel();
	}
	
	public InputTable(int numQBits) {
		super(new MyDefaultTableModel());
		model = (MyDefaultTableModel) getModel();
		insertQuantumStates(numQBits);
	}

	public void addColumn(String name) {
		model.addColumn(name);
	}

	public void addRow() {
		model.addRow(new Object[model.getColumnCount()]);
	}

	public void removeRow(int row) {
		model.removeRow(row);
	}

	public void removeColumn(int column) {
		model.removeColumn(column);
	}

	public void insertQuantumStates(int numQBits) {
		model.clearColumns();
		int states = (int) Math.pow(2, numQBits);
		for (int i = 0; i < states; i++) {
			addColumn(Integer.toBinaryString(i));
		}
	}

}
