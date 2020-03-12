package view.testcaserunner;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import view.tools.InputTable;

public class InputTableView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int defaultNumQBits = 3;

	private InputTable table;

	private JButton setQBits;

	private JButton addRow;

	private JButton removeRow;

	private JButton addColumn;

	private JButton removeColumn;

	private JSpinner numQBits;

	public InputTableView() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Inputs"));

		table = new InputTable(defaultNumQBits);
		add(new JScrollPane(table), BorderLayout.CENTER);

		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(3, 2));

		numQBits = new JSpinner(new SpinnerNumberModel(defaultNumQBits, 1, 10000, 1));
		aux.add(numQBits);

		setQBits = new JButton("Set QBits");
		setQBits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.insertQuantumStates((int) numQBits.getValue());
			}
		});
		aux.add(setQBits);

		addRow = new JButton("Add Row");
		addRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.addRow();
			}
		});
		aux.add(addRow);

		removeRow = new JButton("Remove Row");
		aux.add(removeRow);

		addColumn = new JButton("Add Column");
		aux.add(addColumn);

		removeColumn = new JButton("Remove Column");
		aux.add(removeColumn);

		add(aux, BorderLayout.SOUTH);
	}

}
