package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.util.Pair;
import model.mutant.Mutant;
import model.mutantoperator.MutantOperator;
import model.mutantoperator.qiskit.AndOr;
import model.mutantoperator.qiskit.OrAnd;
import model.mutantoperator.qsharp.GateHX;
import model.mutantoperator.qsharp.GateHY;
import model.mutantoperator.qsharp.GateHZ;
import model.mutantoperator.qsharp.GateST;
import model.mutantoperator.qsharp.GateTS;
import model.mutantoperator.qsharp.GateXH;
import model.mutantoperator.qsharp.GateXY;
import model.mutantoperator.qsharp.GateXZ;
import model.mutantoperator.qsharp.GateYH;
import model.mutantoperator.qsharp.GateYX;
import model.mutantoperator.qsharp.GateYZ;
import model.mutantoperator.qsharp.GateZH;
import model.mutantoperator.qsharp.GateZX;
import model.mutantoperator.qsharp.GateZY;
import model.mutantoperator.qsharp.MissAdjoint;
import model.mutantoperator.qsharp.OneZero;
import model.mutantoperator.qsharp.PauliXY;
import model.mutantoperator.qsharp.PauliXZ;
import model.mutantoperator.qsharp.PauliYX;
import model.mutantoperator.qsharp.PauliYZ;
import model.mutantoperator.qsharp.PauliZX;
import model.mutantoperator.qsharp.PauliZY;
import model.mutantoperator.qsharp.RotXY;
import model.mutantoperator.qsharp.RotXZ;
import model.mutantoperator.qsharp.RotYX;
import model.mutantoperator.qsharp.RotYZ;
import model.mutantoperator.qsharp.RotZX;
import model.mutantoperator.qsharp.RotZY;
import model.mutantoperator.qsharp.ZeroOne;

public class Model implements Observable<Observer> {

	/**
	 * Observer.
	 */
	private Observer observer;

	private boolean qiskit;

	private String path;

	private MutantOperator[] qiskitOperators = { new AndOr(), new OrAnd() };

	private MutantOperator[] qsharpOperators = { new GateHX(), new GateHY(), new GateHZ(), new GateST(), new GateTS(),
			new GateXH(), new GateXY(), new GateXZ(), new GateYH(), new GateYX(), new GateYZ(), new GateZH(),
			new GateZX(), new GateZY(), new MissAdjoint(), new OneZero(), new PauliXY(), new PauliXZ(), new PauliYX(),
			new PauliYZ(), new PauliZX(), new PauliZY(), new RotXY(), new RotXZ(), new RotYX(), new RotYZ(),
			new RotZX(), new RotZY(), new ZeroOne() };

	private ArrayList<Mutant> mutantList;

	public Model() {
		qiskit = false;
		mutantList = new ArrayList<Mutant>();
	}

	/**
	 * Notifies the observer that some error occurred, and throw an exception as
	 * well.
	 */
	private void notifyError(Exception e) {
		String msg = e.getLocalizedMessage();
		observer.onError(msg);
	}

	public void notifyLanguageChange() {
		if (qiskit) {
			observer.updateMutantOperators(qiskitOperators);
		} else {
			observer.updateMutantOperators(qsharpOperators);
		}
	}

	@Override
	public void addObserver(Observer o) {
		observer = o;
	}

	@Override
	public void removeObserver(Observer o) {
		observer = null;
	}

	public void start() {
		updatePath(System.getProperty("user.dir"));
		updateMutantOperators(false);
	}

	public void updateMutantOperators(boolean qiskit) {
		this.qiskit = qiskit;
		if (qiskit) {
			observer.updateMutantOperators(qiskitOperators);
		} else {
			observer.updateMutantOperators(qsharpOperators);
		}
	}

	public void updatePath(String path) {
		this.path = path;
		ArrayList<String> files = new ArrayList<String>();
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files.add(listOfFiles[i].getName());
			}
		}
		observer.updatePath(files);
	}

	public void generate(ArrayList<String> files, ArrayList<MutantOperator> operators) {
		for (int i = 0; i < files.size(); i++) {
			for (int j = 0; j < operators.size(); j++) {
				mutantList.addAll(applyOperatorToFile(files.get(i), operators.get(j)));
			}
		}
		observer.updateMutants(mutantList);
	}

	private ArrayList<Mutant> applyOperatorToFile(String filePath, MutantOperator mutantOperator) {
		ArrayList<Mutant> auxList = new ArrayList<Mutant>();
		String searchWord = mutantOperator.getSearchOperator();
		String replaceWord = mutantOperator.getMutantOperator();
		String completeFilePath = path + File.separator + filePath;
		File originalFile = new File(completeFilePath);
		String file = "";
		BufferedReader reader = null;
		ArrayList<Pair<Integer, Integer>> lineOffset = new ArrayList<Pair<Integer, Integer>>();
		int lineCount = 1;
		int totalOffset = 0;

		try {
			reader = new BufferedReader(new FileReader(originalFile));
			String line = reader.readLine();

			while (line != null) {
				for (int offset = 0; offset < line.length(); offset++) {
					if (line.startsWith(searchWord, offset)) {
						lineOffset.add(new Pair<Integer, Integer>(lineCount, totalOffset + offset));
					}
				}

				file = file + line + System.lineSeparator();
				totalOffset = file.length();
				lineCount++;
				line = reader.readLine();
			}

			StringBuilder fileBuilder = new StringBuilder(file);
			File saveFile;
			BufferedWriter writer = null;
			for (int i = 0; i < lineOffset.size(); i++) {

				fileBuilder.delete(lineOffset.get(i).getValue(), lineOffset.get(i).getValue() + searchWord.length());
				fileBuilder.insert(lineOffset.get(i).getValue(), replaceWord);
				String name = Integer.toString(i) + "_" + mutantOperator.getName() + "_" + filePath;
				String filePathWrite = path + File.separator + name;
				saveFile = new File(filePathWrite);
				try {
					writer = new BufferedWriter(new FileWriter(saveFile));
					writer.write(fileBuilder.toString());
				} finally {
					if (writer != null)
						writer.close();
				}
				auxList.add(new Mutant(name, completeFilePath, filePathWrite, lineOffset.get(i).getKey()));

				// Devolvemos la estructura general de fileBuilder.

				fileBuilder.delete(lineOffset.get(i).getValue(), lineOffset.get(i).getValue() + replaceWord.length());
				fileBuilder.insert(lineOffset.get(i).getValue(), searchWord);
			}
		} catch (IOException e) {
			notifyError(e);
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				notifyError(e);
				e.printStackTrace();
			}
		}
		return auxList;
	}

	public void removeMutants() {
		for (Mutant m : mutantList) {
			try {
				File f = new File(m.getMutantFile()); // file to be delete
				f.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void refreshPath() {
		updatePath(path);
	}

	public void getFileMethods(String fileName) {
		String startMethodToken = "operation ";
		String endMethodToken = "{";
		
		if(qiskit){
			startMethodToken = "TupalabritaMagica";
			endMethodToken = ": ";
		}
		
		ArrayList<String> fileMethods = new ArrayList<String>();
		
		String completeFilePath = path + File.separator + fileName;
		File file = new File(completeFilePath);
		BufferedReader reader = null;
		String fileString = "";
		
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
					fileString = fileString + line + System.lineSeparator();
					line = reader.readLine();
			}
			
			int indexStart = fileString.indexOf(startMethodToken, 0);
			int indexEnd;
			while(indexStart != -1){
				
				indexEnd = fileString.indexOf(endMethodToken, indexStart + startMethodToken.length());
				fileMethods.add(fileString.substring(indexStart + startMethodToken.length(), indexEnd));
				indexStart = fileString.indexOf(startMethodToken,indexEnd + endMethodToken.length());
				
			}
			
		} catch (IOException e) {
			notifyError(e);
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				notifyError(e);
				e.printStackTrace();
			}
		}
		
		observer.updateFileMethods(fileMethods);
		
	}

}
