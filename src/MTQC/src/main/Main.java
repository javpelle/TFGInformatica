package main;

import control.Controller;
import model.Model;
import view.UI;

/**
 * 
 * @author Javier & LUis
 *
 */
public class Main {
	
	/**
	 * Main method. Runs View, Controller and Model modules.
	 * @param args Not used
	 */
	public static void main(String[] args) {
		Model model = new Model();
		Controller c = new Controller(model);
		new UI(c, model);
		c.start();
	}

}
