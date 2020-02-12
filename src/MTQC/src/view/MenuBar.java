package view;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	public MenuBar() {
		JMenu menu1 = new JMenu("File");
		add(menu1);
		menu1.add(new JMenuItem("Save"));

		JMenu  menu2 = new JMenu ("Language");
		ButtonGroup language = new ButtonGroup();
		JRadioButtonMenuItem option1 = new JRadioButtonMenuItem("Q#");
		option1.setSelected(true);
		
		JRadioButtonMenuItem option2 = new JRadioButtonMenuItem("Qiskit");
		option2.setSelected(false);
		
		menu2.add(option1);
		menu2.add(option2);
		language.add(option1);
		language.add(option2);
		
		
		add(menu2);
		

	}

}
