package view.testresultsview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import model.testresult.TestResult;

public class TestResultsView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TabbedResultTable table;

	private JSpinner confidence;
	
	private JButton setConfidence;

	public TestResultsView(ConfidenceListener listener) {
		setLayout(new BorderLayout());
		northPanel(listener);
		centerPanel();
	}

	private void northPanel(ConfidenceListener listener) {
		JPanel north = new JPanel();
		north.setBorder(BorderFactory.createTitledBorder("Confidence Interval (%)"));
		confidence = new JSpinner(new SpinnerNumberModel(1.0, 0, 100.0, 0.1));
		north.add(confidence);
		setConfidence = new JButton("Set confindence (%)");
		
		setConfidence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.updateConfidence((double)confidence.getValue());
			}
		});
		
		north.add(setConfidence);
		add(north, BorderLayout.NORTH);
	}
	
	private void centerPanel() {
		table = new TabbedResultTable();
		add(table, BorderLayout.CENTER);
	}
	
	public void update(ArrayList<ArrayList<TestResult>> results) {
		table.update(results);
	}
	
	public void updateKills(ArrayList<ArrayList<Boolean>> kills) {
		table.updateKills(kills);
		
	}
	
	public interface ConfidenceListener {
		public void updateConfidence(double confidence);
	}
}
