package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	public MenuBar() {
		JMenu menu1 = new JMenu("File");
		add(menu1);
		menu1.add(new JMenuItem("Save"));
		
		JMenu menu2 = new JMenu("Language");
		add(menu2);
		menu2.add(new JMenuItem("Q#"));
		menu2.add(new JMenuItem("Qiskit"));
		
	}

}
