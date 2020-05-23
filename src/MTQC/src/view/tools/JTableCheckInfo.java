package view.tools;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.mutantoperator.MutantOperator;

public class JTableCheckInfo<T> extends JTableCheck<T> {

	private static final long serialVersionUID = 1L;

	public JTableCheckInfo(Object[] columnNames) {
		super(columnNames);
	}

	public void onDoubleClick() {
		MutantOperator m =(MutantOperator) model.getValueAt(getSelectedRow(), 1); 
		String msg = m.getDescription();
		JFrame info = new JFrame();
		JOptionPane.showMessageDialog(info, msg);
	}

}
