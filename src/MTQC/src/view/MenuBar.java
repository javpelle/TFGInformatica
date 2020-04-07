/**
 * This code is part of MTQC.
 * 
 * Copyright (c) 2020 Javier Pellejero, Luis Aguirre.
 * 
 * This code is licensed under the MIT License. You may obtain a copy 
 * of this license in the LICENSE file in the root directory of this source tree 
 * or at https://github.com/javpelle/TFGInformatica/blob/master/LICENSE.
 */

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * Typical menu bar of the UI.
 * 
 * @author luisl
 *
 */
public class MenuBar extends JMenuBar {
	/**
	 * Unique identifier.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * URL for the readme of the repository.
	 */

	private static final String URL_Readme = "https://github.com/javpelle/TFGInformatica/blob/master/README.md";

	/**
	 * Constructor for the class.
	 * 
	 * @param listener      Listener for the language change field.
	 * @param resetListener Listener for the reset button.
	 */
	public MenuBar(LanguageListener listener, ResetListener resetListener) {
		JMenu menu1 = new JMenu("File");
		add(menu1);
		JMenuItem reset = new JMenuItem("Reset");
		menu1.add(reset);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetListener.reset();
			}
		});

		JMenu menu2 = new JMenu("Language");
		ButtonGroup language = new ButtonGroup();
		JRadioButtonMenuItem qsharp = new JRadioButtonMenuItem("Q#");
		qsharp.setSelected(true);

		JRadioButtonMenuItem qiskit = new JRadioButtonMenuItem("Qiskit");
		qiskit.setSelected(false);

		menu2.add(qsharp);
		menu2.add(qiskit);
		language.add(qsharp);
		language.add(qiskit);

		qsharp.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				listener.languageChosen(false);
			}
		});

		qiskit.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				listener.languageChosen(true);
			}
		});

		add(menu2);

		JMenu menu3 = new JMenu("Help");
		add(menu3);
		JMenuItem help = new JMenuItem("Help Contents");
		menu3.add(help);
		help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					java.awt.Desktop.getDesktop().browse(new URI(URL_Readme));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	/**
	 * Interface for the listener on language change.
	 * 
	 * @author Javier & Luis
	 *
	 */
	public interface LanguageListener {
		public void languageChosen(boolean qiskit);
	}

	/**
	 * Interface for the listener on reset button.
	 * 
	 * @author Javier & Luis.
	 *
	 */
	public interface ResetListener {
		public void reset();
	}

}