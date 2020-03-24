package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

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
	}

	public interface LanguageListener {
		public void languageChosen(boolean qiskit);
	}
	
	public interface ResetListener {
		public void reset();
	}

}