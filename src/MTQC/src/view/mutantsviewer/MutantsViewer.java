package view.mutantsviewer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MutantsViewer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MutantsViewer() {
		add(new JScrollPane(new JTextArea()));
	}

}
