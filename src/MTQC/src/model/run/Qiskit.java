/**
 * This code is part of MTQC.
 * 
 * Copyright (c) 2020 Javier Pellejero, Luis Aguirre.
 * 
 * This code is licensed under the MIT License. You may obtain a copy 
 * of this license in the LICENSE file in the root directory of this source tree 
 * or at https://github.com/javpelle/TFGInformatica/blob/master/LICENSE.
 */

package model.run;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

import files.TestFile;
import model.test.Test;
import model.testresult.TestResult;
/**
 * Language concrete class, which overrides some methods in order to implement 
 * the well behavior for Qiskit language.
 * @author Javier & Luis
 *
 */
public class Qiskit extends Language {
	
	/**
	 * Name of the inicialization method.
	 */
	private static final String method = "init";
	
	@Override
	protected TestFile generateFile(String completePath, String fileName, String test, int id_test, String methodName,
			String mutantName) {
		String file = readFile(completePath);
		String newFileName = fileName.substring(0, fileName.length() - 3) + Integer.toString(id_test) + ".py";
		file = "from qiskit import *" + System.lineSeparator() + System.lineSeparator() + file + System.lineSeparator()
				+ test;
		writeFile(path + File.separator + newFileName, file);

		return new TestFile(mutantName, id_test, path, newFileName);
	}

	@Override
	protected String generateImportLanguage() {
		return "from qiskit import *" + System.lineSeparator();
	}

	@Override
	protected String getMethodCall(String file) {
		return file + "." + method;
	}

	@Override
	protected ArrayList<ArrayList<TestResult>> generateResults(BufferedReader in, ArrayList<ArrayList<TestFile>> files,
			Test test) {
		ArrayList<ArrayList<TestResult>> results = new ArrayList<ArrayList<TestResult>>();
		for (ArrayList<TestFile> list : files) {
			ArrayList<TestResult> aux = new ArrayList<TestResult>();
			for (int t = 0; t < list.size(); t++) {
				TestResult tr = test.newTestResult(list.get(t).getMutantName(), list.get(t).getIdTest());
				for (int i = 0; i < test.getShots(); i++) {
					tr.setResult(readLine(in));
				}
				tr.make();
				aux.add(tr);
			}
			results.add(aux);
		}
		return results;
	}

	@Override
	protected String isProbQsharp(Test test) {
		return "";
	}

}
