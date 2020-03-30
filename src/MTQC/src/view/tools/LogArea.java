package view.tools;

import javax.swing.JTextArea;

public class LogArea extends JTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LogArea () {
		setEditable(false);
	}
	
	public void setMessage(String msg) {
		append(msg);
	}
	
	public void clear() {
		setText("");
	}
	
	
}
