package view.nouse;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public void removeColumn(int column) {
		columnIdentifiers.remove(column);
		for (Object row : dataVector) {
			((Vector) row).remove(column);
		}
		fireTableStructureChanged();
	}

	public void clearColumns() {
		int columns = getColumnCount();
		for (int i = 0; i < columns; i++) {
			removeColumn(0);
		}
	}

}
