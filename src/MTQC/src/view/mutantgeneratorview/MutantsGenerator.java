package view.mutantgeneratorview;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MutantsGenerator extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton generate;

	private Operators operators;

	private Files files;

	public MutantsGenerator() {
		setLayout(new BorderLayout());
		
		files = new Files();
		operators = new Operators();
	
		
		add(files, BorderLayout.WEST);
		add(operators, BorderLayout.EAST);

		generate = new JButton("Generate");
		JPanel south = new JPanel();
		south.add(generate);
		add(south, BorderLayout.SOUTH);
	}

}
