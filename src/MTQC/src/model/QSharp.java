package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QSharp {

	public static void run() {

	}
	
	public static void addQSharpMain(String fileName, String methodName, String path, String test) {
		
		String completeFilePath = path + File.separator + fileName;
		File originalFile = new File(completeFilePath);
		String file = "";
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(originalFile));
			String line = reader.readLine();

			while (line != null) {
					file = file + line + System.lineSeparator();
					line = reader.readLine();
			}
			
			String mainMethod = getMainMethod(methodName, test); 
			tabString(mainMethod);
			StringBuilder fileBuilder = new StringBuilder(file);
			int mainPos = fileBuilder.lastIndexOf("}");
			File saveFile;
			BufferedWriter writer = null;
			
			
			fileBuilder.insert(mainPos, mainMethod);
			String filePathWrite = path + File.separator + " modifiedMain" + fileName;
			saveFile = new File(filePathWrite);
			try {
				writer = new BufferedWriter(new FileWriter(saveFile));
				writer.write(fileBuilder.toString());
			} finally {
				if (writer != null)
					writer.close();
			} 
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
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
