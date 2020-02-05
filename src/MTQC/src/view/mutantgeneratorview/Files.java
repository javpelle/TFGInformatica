package view.mutantgeneratorview;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.tools.JTableCheck;
import view.tools.TextField;

public class Files extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTableCheck table;

	private JTextArea path;
	
	private JButton newPath;

	private JTextArea mainFile;

	public Files() {
		setLayout(new BorderLayout());

		Object[][] data = { { true, "Operator1" }, { true, "Operator2" } };
		Object[] column = { "", "File" };
		table = new JTableCheck(data, column);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel south = new JPanel();
		south.setLayout(new BorderLayout());
		path = new JTextArea(System.getProperty("user.dir"));
		newPath = new JButton("Update Path");
		south.add(new JScrollPane(path), BorderLayout.CENTER);
		south.add(newPath, BorderLayout.EAST);
		south.add(new TextField("Current path:"), BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		
		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());
		mainFile = new JTextArea("Operator1");
		mainFile.setEditable(false);
		north.add(mainFile, BorderLayout.SOUTH);
		north.add(new TextField("Current main file:"), BorderLayout.NORTH);
		add(north, BorderLayout.NORTH);
	}

}
