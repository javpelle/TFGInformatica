/**
 * This code is part of MTQC.
 * 
 * Copyright (c) 2020 Javier Pellejero, Luis Aguirre.
 * 
 * This code is licensed under the MIT License. You may obtain a copy 
 * of this license in the LICENSE file in the root directory of this source tree 
 * or at https://github.com/javpelle/TFGInformatica/blob/master/LICENSE.
 */

package view.tools;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * Multiple panel object used to allow the user to write desired tests
 * 
 * @author Javier & Luis
 *
 */
public class TabbedTextArea extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private ArrayList<JTextArea> windows;

	/**
	 * Example test for Qiskit.
	 */
	private static final String qiskitText = "def init ():" + System.lineSeparator() + "\tcr = ClassicalRegister(1)"
			+ System.lineSeparator() + "\tqr = QuantumRegister(1)" + System.lineSeparator()
			+ "\tqc = QuantumCircuit(qr, cr)" + System.lineSeparator() + "" + System.lineSeparator()
			+ "\t# Initialize with desired quantum gates or QuantumCircuit.initialize() method" + System.lineSeparator()
			+ "" + System.lineSeparator() + "\t# Call your method" + System.lineSeparator() + ""
			+ System.lineSeparator() + "\tex = execute(qc, backend = Aer.get_backend('statevector_simulator'))"
			+ System.lineSeparator() + "" + System.lineSeparator() + "\t# Add any operations if needed"
			+ System.lineSeparator() + "\t" + System.lineSeparator()
			+ "\treturn next(iter(ex.result().get_counts())) # Change desired return" + System.lineSeparator()
			+ "\t#return pow(abs(ex.result().get_statevector()), 2) # If probabilistic test chosen";
	/**
	 * Example test for QSharp.
	 */
	private static final String qSharpText = "//Select desired Qubit number to be used" + System.lineSeparator()
			+ "using (register = Qubit[2]) {" + System.lineSeparator() + "" + System.lineSeparator()
			+ "\t//Inicialize variables and Qubits" + System.lineSeparator() + "\tlet count = 1;"
			+ System.lineSeparator() + "\tlet initial = Zero;" + System.lineSeparator() + "" + System.lineSeparator()
			+ "\t//Call method and save output" + System.lineSeparator()
			+ "\tlet(r1,r2,r3) =  TestBellState(register, count, initial);" + System.lineSeparator() + ""
			+ System.lineSeparator() + "\t//If probabilistic test chosen." + System.lineSeparator()
			+ "\t//DumpMachine(\"temp.txt\");" + System.lineSeparator() + System.lineSeparator()
			+ "\t//Reset all qubits to Zero state" + System.lineSeparator() + "\tResetAll(register);"
			+ System.lineSeparator() + "" + System.lineSeparator() + "\t//Return output" + System.lineSeparator()
			+ "\treturn (r1,r2,r3);" + System.lineSeparator() + "}";

	/**
	 * Constructor for the class.
	 */
	public TabbedTextArea() {
		windows = new ArrayList<JTextArea>();
		firstWindow();
		updateLanguage(false);
	}

	/**
	 * Adds a new tab.
	 */
	public void newWindow() {
		JPanel aux = new JPanel(new BorderLayout());
		JTextArea auxWindow = new JTextArea(windows.get(getSelectedIndex()).getText());
		windows.add(auxWindow);
		aux.add(new JScrollPane(auxWindow), BorderLayout.CENTER);
		addTab(String.valueOf(windows.size()), aux);
		setSelectedIndex(windows.size() - 1);
	}

	/**
	 * Creates the first tab.
	 */
	private void firstWindow() {
		JPanel aux = new JPanel(new BorderLayout());
		JTextArea auxWindow = new JTextArea();
		windows.add(auxWindow);
		aux.add(new JScrollPane(auxWindow), BorderLayout.CENTER);
		addTab(String.valueOf(windows.size()), aux);
	}

	/**
	 * Removes the selected tab.
	 */
	public void removeWindow() {
		if (windows.size() > 1) {
			int index = getSelectedIndex();
			remove(index);
			windows.remove(index);
			updateIndex();
		}
	}

	/**
	 * Updates the index of each tab.
	 */
	private void updateIndex() {
		for (int i = 0; i < windows.size(); i++) {
			this.setTitleAt(i, String.valueOf(i + 1));
		}
	}

	/**
	 * Gets the test for the tab collection.
	 * 
	 * @return A list of tests.
	 */
	public ArrayList<String> getTests() {
		ArrayList<String> tests = new ArrayList<String>();
		for (JTextArea w : windows) {
			tests.add(w.getText());
		}
		return tests;
	}

	/**
	 * Updates example test for the tab on language change.
	 * 
	 * @param qiskit Boolean used to know if Qiskit language is selected.
	 */
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
