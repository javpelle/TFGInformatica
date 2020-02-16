package view.mutantgeneratorview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.mutantoperator.MutantOperator;
import view.tools.JTableCheck;

public class Operators extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Object[] column = { "", "Operators" };

	private JTableCheck<MutantOperator> table;

	private JButton all;

	private JButton none;

	public Operators() {
		setLayout(new BorderLayout());

		createCenterPanel();

		createSouthPanel();

	}

	private void createCenterPanel() {
		table = new JTableCheck<MutantOperator>(column);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	private void createSouthPanel() {
		all = new JButton("All");
		none = new JButton("None");
		JPanel south = new JPanel();
		south.add(all);
		south.add(none);
		add(south, BorderLayout.SOUTH);

		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setAllTrue();
			}
		});

		none.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setAllFalse();
			}
		});
	}

	public void updateOperators(MutantOperator[] mutantOperatorList) {
		table.clear();
		for (int i = 0; i < mutantOperatorList.length; ++i) {
			table.addRow(new Object[] { false, mutantOperatorList[i] });
		}
	}

	public ArrayList<MutantOperator> getSelectedOperators() {
		return table.getTrueRows();
	}
}
