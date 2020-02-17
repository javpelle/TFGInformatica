package view.mutantsviewer;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.mutant.Mutant;
import view.tools.JMutantList;

public class MutantsViewer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMutantList mutantList;

	private FileArea fileArea;

	public MutantsViewer() {
		setLayout(new BorderLayout());

		createWestPanel();
		fileArea = new FileArea();
		add(fileArea, BorderLayout.CENTER);

	}

	private void createWestPanel() {
		JPanel west = new JPanel();
		west.setBorder(BorderFactory.createTitledBorder("Mutants"));
		west.setLayout(new BorderLayout());
		mutantList = new JMutantList();
		west.add(new JScrollPane(mutantList), BorderLayout.CENTER);
		add(west, BorderLayout.WEST);

		mutantList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JMutantList list = (JMutantList) evt.getSource();
				if (evt.getClickCount() == 2) {
					// Double-click detected
					updateMutant(list.locationToIndex(evt.getPoint()));
				}
			}
		});
	}

	public void updateMutants(ArrayList<Mutant> mutants) {
		mutantList.clear();
		mutantList.setMutants(mutants);
	}

	private void updateMutant(int i) {
		fileArea.updateMutant(mutantList.getMutant(i));
	}

}
