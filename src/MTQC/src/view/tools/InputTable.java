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

	public InputTable() {
		super(new MyDefaultTableModel());
		model = (MyDefaultTableModel) getModel();
		numQBits = 0;
		addColumn("Quantum Register");
		qiskit = false;
	}
	
	public InputTable(int numQBits) {
		super(new MyDefaultTableModel());
		model = (MyDefaultTableModel) getModel();
		this.numQBits = numQBits;
		addColumn("Quantum Register");
		qiskit = false;
	}

	public void addColumn(String name) {
		model.addColumn(name);
	}

	public void addRow() {
		Object [] aux = new Object[model.getColumnCount()];
		aux[0] = newDefaultState();
		model.addRow(aux);
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

	public void removeRow(int row) {
		model.removeRow(row);
	}

	public void removeColumn(int column) {
		model.removeColumn(column);
	}

	public void insertQuantumStates(int numQBits) {
		this.numQBits = numQBits;
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(newDefaultState(), i, 0);
		}
	}
	
	public void updateLanguage(boolean qiskit) {
		this.qiskit = qiskit;
		insertQuantumStates(numQBits);
	}

}
