package control;

import java.util.ArrayList;

import model.Model;
import model.mutantoperator.MutantOperator;

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

	public void updateLanguage(boolean qiskit) {
		model.updateMutantOperators(qiskit);		
	}

	public void generate(ArrayList<String> files, ArrayList<MutantOperator> operators) {
		model.generate(files, operators);
		
	}
}
