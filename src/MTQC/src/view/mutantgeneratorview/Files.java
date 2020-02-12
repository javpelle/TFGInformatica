package view.mutantgeneratorview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.tools.JTableCheck;

public class Files extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTableCheck table;

	private JTextArea path;

	private JButton all;

	private JButton none;

	private JButton newPath;

	// private JTextArea mainFile;

	public Files() {
		setLayout(new BorderLayout());

		// createNorthPanel();

		Object[][] data = { { false, "File1" }, { false, "File2" } };
		createCenterPanel(data);

		createSouthPanel();

	}

	/*
	 * private void createNorthPanel() { JPanel north = new JPanel();
	 * north.setLayout(new BorderLayout()); mainFile = new JTextArea("File1");
	 * mainFile.setEditable(false); north.add(mainFile, BorderLayout.SOUTH);
	 * north.add(new TextField("Current main file:"), BorderLayout.NORTH);
	 * add(north, BorderLayout.NORTH); }
	 */
	private void createCenterPanel(Object[][] data) {
		Object[] column = { "", "File" };

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		table = new JTableCheck(data, column);
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

	private void createSouthPanel() {
		JPanel south = new JPanel();
		south.setBorder(BorderFactory.createTitledBorder("Current path"));
		south.setLayout(new BorderLayout());
		path = new JTextArea(System.getProperty("user.dir"));
		newPath = new JButton("Update Path");
		south.add(new JScrollPane(path), BorderLayout.CENTER);
		south.add(newPath, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
	}

}
