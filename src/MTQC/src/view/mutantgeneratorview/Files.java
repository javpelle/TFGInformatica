package view.mutantgeneratorview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.tools.JTableCheck;

public class Files extends JPanel {

	private static final long serialVersionUID = 1L;

	private final static Object[] column = { "", "File" };

	private JPanel center;

	private JTableCheck table;

	private JTextArea path;

	private JButton all;

	private JButton none;

	private JButton newPath;

	public Files(NewPathListener listener) {
		setLayout(new BorderLayout());

		createCenterPanel();

		createSouthPanel(listener);

	}

	private void createCenterPanel() {
		center = new JPanel();
		center.setLayout(new BorderLayout());
		table = new JTableCheck(column);
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

	private void createSouthPanel(NewPathListener listener) {
		JPanel south = new JPanel();
		south.setBorder(BorderFactory.createTitledBorder("Current path"));
		south.setLayout(new BorderLayout());
		path = new JTextArea(System.getProperty("user.dir"));
		newPath = new JButton("Update Path");
		south.add(new JScrollPane(path), BorderLayout.CENTER);
		south.add(newPath, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);

		newPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.updatePath(path.getText());
			}
		});
	}

	public void updatePath(ArrayList<String> files) {
		table.clear();
		for (int i = 0; i < files.size(); ++i) {
			table.addRow(new Object[] { false, files.get(i) });
		}
	}

	public interface NewPathListener {
		public void updatePath(String path);
	}

}
