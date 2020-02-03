package view.mutantgeneratorview;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class MutantsGenerator extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel center;
	private Operators operators;
	private Files files;
	
	public MutantsGenerator() {
		setLayout(new BorderLayout());
		center = new JPanel();
		add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(1, 2));
		
		files = new Files();		
		operators = new Operators();
		center.add(files);
		center.add(operators);
	}

}
