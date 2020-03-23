package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class QSharp extends Language {
	
	private static String namespace = "";

	public QSharp(){
		main = "main_python.py";
		init =  "main_qsharp.qs";
	}
	
	protected String runShot(double timeLimit) {
		String mainPython = "import qsharp" + System.lineSeparator() + "import " + namespace + " as qm" 
		+ System.lineSeparator() + "print(qm.MainQuantum.simulate())";
		this.writeFile(main, mainPython);
		return null;
	}

	protected String generateFile(String fileName, String methodName, String test) {
		
		File originalFile = new File(fileName);
		String file = "";
		BufferedReader reader = null;
		StringBuilder fileBuilder = null;
		try {
			reader = new BufferedReader(new FileReader(originalFile));
			String line = reader.readLine();

			while (line != null) {
					file = file + line + System.lineSeparator();
					line = reader.readLine();
			}
			
			reader.close(); 
			setNamespace(file);
			String mainMethod = getMainMethod(methodName, test); 
			mainMethod = tabString(mainMethod);
			fileBuilder = new StringBuilder(file);
			int mainPos = fileBuilder.lastIndexOf("}");	
			fileBuilder.insert(mainPos, mainMethod);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileBuilder.toString();
	}

	private static void setNamespace(String file) {
		String token = "namespace ";
		int ini =  file.indexOf(token);
		int end = file.indexOf("{", ini);
		namespace = file.substring(ini, end);
		
	}

	private static String getMainMethod(String methodName, String testInput) {
		String outputType = getOutputType(methodName);
		return getMainHeader() + outputType + "{" + System.lineSeparator() + tabString(testInput) +
				System.lineSeparator() + "}" + System.lineSeparator();
	
	}
	

	private static String getOutputType(String methodName) {
		int index = methodName.lastIndexOf(":", methodName.length());
		return methodName.substring(index);
	}
	
	private static String getMainHeader(){
		return "operation MainQuantum() ";
	}
	
	private static String tabString(String input) {
		StringBuilder builder = new StringBuilder(input);
		builder.insert(0, "\t");
		
		int index = builder.indexOf(System.lineSeparator());
	    while (index != -1)
	    {
	        builder.replace(index, index + System.lineSeparator().length(), System.lineSeparator() + "\t");
	        index += (System.lineSeparator() + "\t").length(); 
	        index = builder.indexOf(System.lineSeparator(), index);
	    }
		return builder.toString();
	}
	
	
	/*
	 * NOT IN USE
	 
	private static String getMethodCall(String methodName, int numberOfOutputs) {
		String methodCall = "";
		if (numberOfOutputs > 0) {
			methodCall = methodCall + "let (";
			int i = 1;
			while(i < numberOfOutputs) {
				methodCall = methodCall + "r" + Integer.toString(i) + ", ";
				i++;
			}
			methodCall = methodCall + "r" + Integer.toString(i) + ")= ";
		}
		
		StringBuilder fileBuilder = new StringBuilder(methodName);
		int index = fileBuilder.length();
		//fileBuiler
		//methodCall = methodCall + 
		return methodCall;
		
	} 
	
	/* NOT IN USE
	 * private static String getUsingDeclaration(String numberOfQubits) {
			return "\t" + "(register[" + numberOfQubits + "]) {" + System.lineSeparator();
	}
	 */
	
	/* NOT IN USE
	 * private static int getNumberOfOutputs(String outputType) {
		int lastIndex = 0;
		int count = 0;
		if (outputType.contains("Unit")) {
			return 0;
		} else {
			while(lastIndex != -1){
			    lastIndex = outputType.indexOf(",",lastIndex);
			    if(lastIndex != -1){
			        count ++;
			        lastIndex += 1;
			    }
			}
			return count + 1;
		}
		
	}
	 */
}
