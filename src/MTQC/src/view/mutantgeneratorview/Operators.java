package view.mutantgeneratorview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.tools.JTableCheck;

public class Operators extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTableCheck table;
	
	private JButton all;

	private JButton none;

	public Operators() {
		setLayout(new BorderLayout());
		
		Object[][] data = { { false, "Operator1" }, { false, "Operator2" } };
		
		createCenterPanel(data);

		createSouthPanel(data);
		
		
	}
	
	private void createCenterPanel(Object[][] data) {
		Object[] column = { "", "Operator" };
		table = new JTableCheck(data, column);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	private void createSouthPanel(Object[][] data) {
		all = new JButton("All");
		none = new JButton("None");
		JPanel south = new JPanel();
		south.add(all);
		south.add(none);
		add(south, BorderLayout.SOUTH);

		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Object[] row : data) {
					row[0] = true;
				}
				table.updateUI();
			}
		});

		none.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Object[] row : data) {
					row[0] = false;
				}
				table.updateUI();
			}
		});	
	}
}
