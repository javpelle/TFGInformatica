package control;

import model.Model;

public class Controller {

	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	public void start() {
		model.start();
	}

	public void updatePath(String path) {
		model.updatePath(path);
	}
}
