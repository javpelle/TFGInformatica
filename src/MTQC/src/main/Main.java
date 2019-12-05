package main;

import control.Controller;
import model.Model;
import view.UI;

public class Main {
	
	public static void main(String[] args) {
		new UI(new Controller(), new Model());
	}

}
