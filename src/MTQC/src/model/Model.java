package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import exception.EmptyListException;
import exception.NullStringException;
import exception.ShotsException;
import exception.TimeLimitException;
import javafx.util.Pair;
import model.mutant.Mutant;
import model.mutantoperator.MutantOperator;
import model.mutantoperator.qiskit.CCXCSWAPGate;
import model.mutantoperator.qiskit.CHSWAPGate;
import model.mutantoperator.qiskit.CHXGate;
import model.mutantoperator.qiskit.CHYGate;
import model.mutantoperator.qiskit.CHZGate;
import model.mutantoperator.qiskit.CSWAPCCXGate;
import model.mutantoperator.qiskit.CXHGate;
import model.mutantoperator.qiskit.CXSWAPGate;
import model.mutantoperator.qiskit.CXYGate;
import model.mutantoperator.qiskit.CXZGate;
import model.mutantoperator.qiskit.CYHGate;
import model.mutantoperator.qiskit.CYSWAPGate;
import model.mutantoperator.qiskit.CYXGate;
import model.mutantoperator.qiskit.CYZGate;
import model.mutantoperator.qiskit.CZHGate;
import model.mutantoperator.qiskit.CZSWAPGate;
import model.mutantoperator.qiskit.CZXGate;
import model.mutantoperator.qiskit.CZYGate;
import model.mutantoperator.qiskit.HXGate;
import model.mutantoperator.qiskit.HYGate;
import model.mutantoperator.qiskit.HZGate;
import model.mutantoperator.qiskit.RXYGate;
import model.mutantoperator.qiskit.RXZGate;
import model.mutantoperator.qiskit.RYXGate;
import model.mutantoperator.qiskit.RYZGate;
import model.mutantoperator.qiskit.RZXGate;
import model.mutantoperator.qiskit.RZYGate;
import model.mutantoperator.qiskit.SSdgGate;
import model.mutantoperator.qiskit.STGate;
import model.mutantoperator.qiskit.SWAPCHGate;
import model.mutantoperator.qiskit.SWAPCXGate;
import model.mutantoperator.qiskit.SWAPCYGate;
import model.mutantoperator.qiskit.SWAPCZGate;
import model.mutantoperator.qiskit.SZGate;
import model.mutantoperator.qiskit.SdgSGate;
import model.mutantoperator.qiskit.SdgTGate;
import model.mutantoperator.qiskit.SdgZGate;
import model.mutantoperator.qiskit.TSGate;
import model.mutantoperator.qiskit.TSdgGate;
import model.mutantoperator.qiskit.TZGate;
import model.mutantoperator.qiskit.XHGate;
import model.mutantoperator.qiskit.XYGate;
import model.mutantoperator.qiskit.XZGate;
import model.mutantoperator.qiskit.YHGate;
import model.mutantoperator.qiskit.YXGate;
import model.mutantoperator.qiskit.YZGate;
import model.mutantoperator.qiskit.ZHGate;
import model.mutantoperator.qiskit.ZSGate;
import model.mutantoperator.qiskit.ZSdgGate;
import model.mutantoperator.qiskit.ZTGate;
import model.mutantoperator.qiskit.ZXGate;
import model.mutantoperator.qiskit.ZYGate;
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
import model.run.Language.NotifyListener;
import model.run.QSharp;
import model.run.Qiskit;
import model.test.OutputTest;
import model.test.ProbabilityTest;
import model.test.Test;

public class Model implements Observable<Observer> {

	/**
	 * Observer.
	 */
	private Observer observer;

	private boolean qiskit;

	private String path;

	private static final String mutantPath = ".mutants";

	private MutantOperator[] qiskitOperators = { new CCXCSWAPGate(), new CHSWAPGate(), new CHXGate(), new CHYGate(),
			new CHZGate(), new CSWAPCCXGate(), new CXHGate(), new CXSWAPGate(), new CXYGate(), new CXZGate(),
			new CYHGate(), new CYSWAPGate(), new CYXGate(), new CYZGate(), new CZHGate(), new CZSWAPGate(),
			new CZXGate(), new CZYGate(), new HXGate(), new HYGate(), new HZGate(), new RXYGate(), new RXZGate(),
			new RYXGate(), new RYZGate(), new RZXGate(), new RZYGate(), new SdgSGate(), new SdgTGate(), new SdgZGate(),
			new SSdgGate(), new STGate(), new SWAPCHGate(), new SWAPCXGate(), new SWAPCYGate(), new SWAPCZGate(),
			new SZGate(), new TSdgGate(), new TSGate(), new TZGate(), new XHGate(), new XYGate(), new XZGate(),
			new YHGate(), new YXGate(), new YZGate(), new ZHGate(), new ZSdgGate(), new ZSGate(), new ZTGate(),
			new ZXGate(), new ZYGate() };

	private MutantOperator[] qsharpOperators = { new GateHX(), new GateHY(), new GateHZ(), new GateST(), new GateTS(),
			new GateXH(), new GateXY(), new GateXZ(), new GateYH(), new GateYX(), new GateYZ(), new GateZH(),
			new GateZX(), new GateZY(), new MissAdjoint(), new OneZero(), new PauliXY(), new PauliXZ(), new PauliYX(),
			new PauliYZ(), new PauliZX(), new PauliZY(), new RotXY(), new RotXZ(), new RotYX(), new RotYZ(),
			new RotZX(), new RotZY(), new ZeroOne() };

	private Test[] tests = { new ProbabilityTest(), new OutputTest() };

	private ArrayList<Mutant> mutantList;

	public Model() {
		qiskit = false;
		mutantList = new ArrayList<Mutant>();
	}

	/**
	 * Notifies the observer that some error occurred, and throw an exception as
	 * well.
	 */
	public void notifyError(Exception e) {
		String msg = e.getLocalizedMessage();
		observer.onError(msg);
	}

	public void notifyLanguageChange() {
		if (qiskit) {
			observer.updateMutantOperators(qiskitOperators, true);
		} else {
			observer.updateMutantOperators(qsharpOperators, false);
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
		updateMutantOperators(qiskit);
		observer.setTests(tests);
	}

	public void reset() {
		removeMutants();
		mutantList = new ArrayList<Mutant>();
		start();
		observer.updateMutants(mutantList);
		observer.updateFileMethods(new ArrayList<String>(), mutantList, null);
	}

	public void updateMutantOperators(boolean qiskit) {
		this.qiskit = qiskit;
		updatePath(path);
		notifyLanguageChange();
	}

	public void updatePath(String path) {
		this.path = path;
		ArrayList<String> files = new ArrayList<String>();
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		String extension;
		if (qiskit) {
			extension = ".py";
		} else {
			extension = ".qs";
		}
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(extension)
					&& !listOfFiles[i].getName().startsWith("._")) {
				files.add(listOfFiles[i].getName());
			}
		}
		observer.updatePath(files);
	}

	public void generate(ArrayList<String> files, ArrayList<MutantOperator> operators) {
		if (files.isEmpty()) {
			observer.notifyMutantsGenerator("No files selected!\n");
		} else if (operators.isEmpty()) {
			observer.notifyMutantsGenerator("No operators selected!\n");
		} else {
			File file = new File(mutantPath);
			file.mkdir();
			for (int i = 0; i < files.size(); i++) {
				for (int j = 0; j < operators.size(); j++) {
					mutantList.addAll(applyOperatorToFile(files.get(i), operators.get(j)));
				}
			}
			observer.notifyMutantsGenerator(
					"Completed. " + String.valueOf(mutantList.size()) + " mutants generated!\n");
			observer.updateMutants(mutantList);
		}
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
				line = " " + line;
				for (int offset = 1; offset < line.length(); offset++) {
					if (line.startsWith(searchWord, offset) && (qiskit || mutantOperator
							.checkRegEx(line.substring(offset - 1, offset + searchWord.length() + 1)))) {
						lineOffset.add(new Pair<Integer, Integer>(lineCount, totalOffset + offset - 1));
					}
				}

				file = file + line.substring(1) + System.lineSeparator();
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
				String name = "_" + Integer.toString(i) + "_" + mutantOperator.getName() + "_" + filePath;
				String filePathWrite = mutantPath + File.separator + name;
				saveFile = new File(filePathWrite);
				try {
					writer = new BufferedWriter(new FileWriter(saveFile));
					writer.write(fileBuilder.toString());
				} finally {
					if (writer != null)
						writer.close();
				}
				auxList.add(new Mutant(name, path, filePath, mutantPath, name, lineOffset.get(i).getKey()));

				// Devolvemos la estructura general de fileBuilder.

				fileBuilder.delete(lineOffset.get(i).getValue(), lineOffset.get(i).getValue() + replaceWord.length());
				fileBuilder.insert(lineOffset.get(i).getValue(), searchWord);
			}
		} catch (

		IOException e) {
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
				File f = new File(m.getMutantCompletePath()); // file to be delete
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
		String startMethodToken;
		String endMethodToken;

		if (qiskit) {
			startMethodToken = "def ";
			endMethodToken = ":";
		} else {
			startMethodToken = "operation ";
			endMethodToken = "{";
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
			while (indexStart != -1) {

				indexEnd = fileString.indexOf(endMethodToken, indexStart + startMethodToken.length());
				fileMethods.add(fileString.substring(indexStart + startMethodToken.length(), indexEnd));
				indexStart = fileString.indexOf(startMethodToken, indexEnd + endMethodToken.length());

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

		observer.updateFileMethods(fileMethods, mutantList, fileName);

	}

	public void setTimeLimit(double timeLimit) {

	}

	public void run(ArrayList<Mutant> mutantList, ArrayList<String> testSuit, Test test, String file, String method,
			double timeLimit) {
		try {
			if (timeLimit <= 0) {
				throw new TimeLimitException();
			}
			if (test.getShots() <= 0) {
				throw new ShotsException();
			}
			if (testSuit.size() == 0) {
				throw new EmptyListException("Test list");
			}
			if (file == null || file.equals("")) {
				throw new NullStringException("file");
			}
			if (method == null || file.equals("")) {
				throw new NullStringException("method");
			}
			if (mutantList.size() == 0) {
				throw new EmptyListException("Mutant list");
			}

			NotifyListener listener = new NotifyListener() {

				@Override
				public void notify(String msg) {
					observer.notifyTestCaseRunner(msg);
				}

			};
			if (qiskit) {
				new Qiskit(listener).run(mutantList, testSuit, test, file, method, timeLimit);
			} else {
				new QSharp(listener).run(mutantList, testSuit, test, file, method, timeLimit);
			}
		} catch (TimeLimitException | ShotsException | EmptyListException | NullStringException e) {
			notifyError(e);
		}
	}

}
