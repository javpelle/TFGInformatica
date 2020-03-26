package model.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import files.TestFile;
import model.test.Test;

public class Qiskit extends Language {

	private String[] pythonCall;

	public Qiskit() {
		main = "qiskit\\main_qiskit.py";
		pythonCall = pythonCall(main);
	}
	
	protected String runShot(double timeLimit) {
		String ret = null;
		try {
			
			Process p = Runtime.getRuntime().exec(pythonCall);
			if(!p.waitFor((long) timeLimit, TimeUnit.SECONDS)) {
			    //timeout - kill the process. 
			    p.destroy(); // consider using destroyForcibly instead
			} else {
				BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
				ret = in.readLine();
			}			
		} catch (IOException | InterruptedException e) {

		}
		if (ret.equals("null")) {
			ret = null;
		}
		return ret;
	}

	protected String generateFile(String initialize, String file, String method) {
		String path = "";		
		String header = "import sys" + System.lineSeparator();
		header += "sys.path.insert(0, " + path + ")" + System.lineSeparator();
		header += "from " + file + " import " + method + System.lineSeparator();
		return header + System.lineSeparator() + initialize;
	}

	@Override
	protected void generateMain(ArrayList<ArrayList<TestFile>> files, Test test, double timeLimit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected TestFile generateFile(String pathFile, String test, int id_test) {
		// TODO Auto-generated method stub
		return null;
	}

}
