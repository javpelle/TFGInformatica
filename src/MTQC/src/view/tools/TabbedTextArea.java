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

	private static final String qiskitText = "def init ():" + System.lineSeparator() + "\tcr = ClassicalRegister(1)"
			+ System.lineSeparator() + "\tqr = QuantumRegister(1)" + System.lineSeparator()
			+ "\tqc = QuantumCircuit(qr, cr)" + System.lineSeparator() + "" + System.lineSeparator()
			+ "\t# Initialize with desired quantum gates or QuantumCircuit.initialize() method" + System.lineSeparator()
			+ "" + System.lineSeparator() + "\t# Call your method" + System.lineSeparator() + ""
			+ System.lineSeparator() + "\tex = execute(qc, backend = Aer.get_backend('statevector_simulator'))"
			+ System.lineSeparator() + "" + System.lineSeparator() + "\t# Add any operations if needed"
			+ System.lineSeparator() + "\t" + System.lineSeparator()
			+ "\treturn ex.result().get_counts() # Change desired return" + System.lineSeparator()
			+ "\t#return pow(abs(ex.result().get_statevector()), 2) # If probabilistic test chosen";

	private static final String qSharpText = "//Select desired Qubit number to be used" + System.lineSeparator()
			+ "using (register = Qubit[2]) {" + System.lineSeparator() + "" + System.lineSeparator()
			+ "\t//Inicialize variables and Qubits" + System.lineSeparator() + "\tlet count = 1;"
			+ System.lineSeparator() + "\tlet initial = Zero;" + System.lineSeparator() + "" + System.lineSeparator()
			+ "\t//Call method and save output" + System.lineSeparator()
			+ "\tlet(r1,r2,r3) =  TestBellState(register, count, initial);" + System.lineSeparator() + ""
			+ System.lineSeparator() + "\t//Reset all qubits to Zero state" + System.lineSeparator()
			+ "\tResetAll(register);" + System.lineSeparator() + "" + System.lineSeparator() + "\t//Return output"
			+ System.lineSeparator() + "\treturn (r1,r2,r3);" + System.lineSeparator()
			+ "\t//DumpMachine(\"dump.txt\");// If probabilistic test chosen. Don't change dump.txt" + System.lineSeparator() + "}";

	public TabbedTextArea() {
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
		setSelectedIndex(windows.size() - 1);
	}

	private void firstWindow() {
		JPanel aux = new JPanel(new BorderLayout());
		JTextArea auxWindow = new JTextArea();
		windows.add(auxWindow);
		aux.add(new JScrollPane(auxWindow), BorderLayout.CENTER);
		addTab(String.valueOf(windows.size()), aux);
	}

	public void removeWindow() {
		if (windows.size() > 1) {
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
		for (JTextArea w : windows) {
			tests.add(w.getText());
		}
		return tests;
	}

	public void updateLanguage(boolean qiskit) {
		if (qiskit) {
			for (JTextArea w : windows) {
				w.setText(qiskitText);
			}
		} else {
			for (JTextArea w : windows) {
				w.setText(qSharpText);
			}
		}

	}

}
