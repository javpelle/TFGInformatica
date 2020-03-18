package view.tools;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class TabbedTextArea extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<JTextArea> windows;

	private static final String qiskitText = "def __init__ ():" + System.lineSeparator()  + 
			"\tcr = ClassicalRegister(1)" + System.lineSeparator()  + 
			"\tqr = QuantumRegister(1)" + System.lineSeparator()  + 
			"\tqc = QuantumCircuit(qr, cr)" + System.lineSeparator()  + 
			"" + System.lineSeparator()  + 
			"\t# Initialize with desired quantum gates or QuantumCircuit.initialize() method" + System.lineSeparator()  + 
			"" + System.lineSeparator()  + 
			"\t# Call your method" + System.lineSeparator()  + 
			"" + System.lineSeparator()  + 
			"\tex = execute(qc, backend = Aer.get_backend('statevector_simulator'))" + System.lineSeparator()  + 
			"" + System.lineSeparator()  + 
			"\t# Add any operations if needed" + System.lineSeparator()  + 
			"\t" + System.lineSeparator()  + 
			"\treturn ex.result().get_counts() # Change desired return";

	private static final String qSharpText = "jaja";
	
	public TabbedTextArea () {
		windows = new ArrayList<JTextArea>();
		firstWindow();
		updateLanguage(false);
	}
	
	public void newWindow() {
		JPanel aux = new JPanel(new BorderLayout());
		JTextArea auxWindow = new JTextArea(windows.get(getSelectedIndex()).getText());
		windows.add(auxWindow);
		aux.add(new JScrollPane(auxWindow), BorderLayout.CENTER);
		addTab(String.valueOf(windows.size()), aux);
	}
	
	private void firstWindow() {
		JPanel aux = new JPanel(new BorderLayout());
		JTextArea auxWindow = new JTextArea();
		windows.add(auxWindow);
		aux.add(new JScrollPane(auxWindow), BorderLayout.CENTER);
		addTab(String.valueOf(windows.size()), aux);
	}
	
	public void removeWindow() {
		if (windows.size() > 0) {
			int index = getSelectedIndex();
			remove(index);
			windows.remove(index);
			updateIndex();	
		}
	}

	private void updateIndex() {
		for (int i = 0; i < windows.size(); i++) {
			this.setTitleAt(i, String.valueOf(i + 1));
		}
	}
	
	public ArrayList<String> getTests() {
		ArrayList<String> tests = new ArrayList<String>();
		for (JTextArea w: windows) {
			tests.add(w.getText());
		}
		return tests;
	}

	public void updateLanguage(boolean qiskit) {
		if (qiskit) {
			for (JTextArea w: windows) {
				w.setText(qiskitText);
			}
		} else {
			for (JTextArea w: windows) {
				w.setText(qSharpText);
			}
		}
		
	}

}
