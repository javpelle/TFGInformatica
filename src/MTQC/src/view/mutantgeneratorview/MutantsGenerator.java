package view.mutantgeneratorview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.mutantoperator.MutantOperator;
import view.mutantgeneratorview.Files.NewPathListener;

public class MutantsGenerator extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton generate;

	private Operators operators;

	private Files files;

	public MutantsGenerator(NewPathListener listener, NewGenerateListener listenGenerate) {
		setLayout(new BorderLayout());

		files = new Files(listener);
		operators = new Operators();

		add(files, BorderLayout.WEST);
		add(operators, BorderLayout.EAST);

		generate = new JButton("Generate");
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listenGenerate.generate(files.getSelectedFiles(), operators.getSelectedOperators());
			}
		});
		JPanel south = new JPanel();
		south.add(generate);
		add(south, BorderLayout.SOUTH);
	}

	public void updatePath(ArrayList<String> fileList) {
		files.updatePath(fileList);
	}

	public void updateOperators(MutantOperator[] mutantOperatorList) {
		operators.updateOperators(mutantOperatorList);
	}
	
	public interface NewGenerateListener {
		public void generate(ArrayList<String> files, ArrayList<MutantOperator> operators);
	}

}
