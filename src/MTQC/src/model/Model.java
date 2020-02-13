package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

	public Model() {
		qiskit = false;
	}

	/**
	 * Notifies the observer that some error occurred, and throw an exception as
	 * well.
	 */
	private void notifyError(RuntimeException e) {
		String msg = e.getLocalizedMessage();
		observer.onError(msg);

		throw e;
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
				applyOperatorToFile(files.get(i), operators.get(j));
			}
		}
		
	}

	private void applyOperatorToFile(String filePath, MutantOperator mutantOperator) {
		
		String searchWord = mutantOperator.getSearchOperator();
		String replaceWord = mutantOperator.getMutantOperator();
	 	File originalFile = new File(filePath);
        String file = "";
        BufferedReader reader = null;
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(originalFile));
            String line = reader.readLine();
             
            while (line != null) 
            {
            	file = file + line + System.lineSeparator();   
                line = reader.readLine();
            }
             
             
            String[] splitSearch = file.split(searchWord);
            String aux = new String();
            for (int i = 0; i < splitSearch.length; i++) {
            	aux = splitSearch[i];
            	if (splitSearch[i].equals(searchWord)) {
            		splitSearch[i] = replaceWord;
            	}
            	
            	String modifiedFile = Arrays.toString(splitSearch);
            	//Falta crear el nuevo archivo, con el nombre adecuado y escrbir en el el contenido de modifiedFile
            	splitSearch[i] = aux;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {   
                reader.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
   }
		


}
