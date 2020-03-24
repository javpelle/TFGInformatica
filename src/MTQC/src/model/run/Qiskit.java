package model.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Qiskit extends Language {

	private String[] pythonCall;

	public Qiskit() {
		main = "qiskit\\main_qiskit.py";
		init = "qiskit\\init_qiskit.py";
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
		String header = "from " + file + " import " + method + System.lineSeparator();
		return header + System.lineSeparator() + initialize;
	}

}
