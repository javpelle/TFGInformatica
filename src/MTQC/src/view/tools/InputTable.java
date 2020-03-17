package view.tools;

import javax.swing.JTable;

public class InputTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MyDefaultTableModel model;
	
	private int numQBits;
	
	private boolean qiskit;
			

	public InputTable(int numQBits) {
		super(new MyDefaultTableModel());
		model = (MyDefaultTableModel) getModel();
		
		this.numQBits = numQBits;
		qiskit = false;
		
		addEmptyColumn();
		addEmptyRow();
		
		addColumn("Quantum Register");
		addRow();
		
		updateColumnIndex();
		updateRowIndex();
		
		getTableHeader().setReorderingAllowed(false);
	}

	private void updateRowIndex() {
		for (int i = 1; i < model.getRowCount(); i++) {
			model.setValueAt(i, i, 0);
		}
	}
	
	private void updateColumnIndex() {
		for (int i = 1; i < model.getColumnCount(); i++) {
			model.setValueAt(i, 0, i);
		}
	}

	public void addColumn(String name) {
		int column = model.getColumnCount();
		model.addColumn(name);
		model.setValueAt(column, 0, column);
	}
	
	private void addEmptyColumn() {
		model.addColumn("");
	}

	public void addRow() {
		Object [] aux = new Object[model.getColumnCount()];
		aux[0] = model.getRowCount();
		aux[1] = newDefaultState();
		model.addRow(aux);
	}
	
	private void addEmptyRow() {
		model.addRow(new Object[model.getColumnCount()]);
	}

	public void removeRow() {
		int row = getSelectedRow();
		if (row != -1 && row != 0) {
			model.removeRow(row);
			updateRowIndex();
		}
	}

	public void removeColumn() {
		int column = getSelectedColumn();
		if (column != -1 && column != 0 && column != 1) {
			model.removeColumn(column);
			updateColumnIndex();
		}
	}

	public void insertQuantumStates(int numQBits) {
		this.numQBits = numQBits;
		for (int i = 1; i < model.getRowCount(); i++) {
			model.setValueAt(newDefaultState(), i, 1);
		}
	}
	
	public void updateLanguage(boolean qiskit) {
		this.qiskit = qiskit;
		insertQuantumStates(numQBits);
	}
	
	private String newDefaultState() {
		if (qiskit) {
			String aux = "[complex(1, 0)";
			int states = (int) Math.pow(2, numQBits);
			for (int i = 1; i < states; i++) {
				aux += ", 0";
			}
			aux +=  "]";
			return aux;
		} else {
			String aux = "I(register[0]);";
			for (int i = 1; i < numQBits; i++) {
				aux += "I(register[" + i + "]);";
			}
			return aux;
		} 
		
	}
	
	public boolean isCellEditable(int row, int column) {
		return column != 0 && row != 0;
	}

}
