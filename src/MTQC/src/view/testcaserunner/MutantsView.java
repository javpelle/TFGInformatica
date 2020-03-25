package view.testcaserunner;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.mutant.Mutant;
import view.tools.JTableCheck;

public class MutantsView extends JPanel {

	private static final long serialVersionUID = 1L;

	private final static Object[] column = { "", "Mutant" };

	private JPanel center;

	private JTableCheck<Mutant> table;

	private JButton all;

	private JButton none;

	public MutantsView() {
		setLayout(new BorderLayout());

		createCenterPanel();

	}

	private void createCenterPanel() {
		center = new JPanel();
		center.setLayout(new BorderLayout());
		table = new JTableCheck<Mutant>(column);
		all = new JButton("All");
		none = new JButton("None");
		JPanel centerSouth = new JPanel();
		centerSouth.add(all);
		centerSouth.add(none);
		center.add(new JScrollPane(table), BorderLayout.CENTER);
		center.add(centerSouth, BorderLayout.SOUTH);
		add(center, BorderLayout.CENTER);

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

	public ArrayList<Mutant> getSelectedFiles() {
		return table.getTrueRows();
	}

	public void updateMutants(ArrayList<Mutant> mutants, String file) {
		table.clear();
		for (int i = 0; i < mutants.size(); ++i) {
			if (mutants.get(i).getOriginalName().equals(file)) {
				table.addRow(new Object[] { false, mutants.get(i) });
			}
		}	
	}

}
