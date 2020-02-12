package main;

import control.Controller;
import model.Model;
import view.UI;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		Controller c = new Controller(model);
		new UI(c, model);
		c.start();
	}

}
