package view.tools;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.mutant.Mutant;

public class JMutantList extends JList<Mutant> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DefaultListModel<Mutant> model;

	public JMutantList() {
		super(new DefaultListModel<Mutant>());
		model = (DefaultListModel<Mutant>) getModel();
	}

	public void setMutants(ArrayList<Mutant> mutants) {
		for (int i = 0; i < mutants.size(); i++) {
			model.addElement(mutants.get(i));
		}
	}

	public void clear() {
		model.clear();
	}

}
