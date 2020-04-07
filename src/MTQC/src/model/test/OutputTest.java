/**
 * This code is part of MTQC.
 * 
 * Copyright (c) 2020 Javier Pellejero, Luis Aguirre.
 * 
 * This code is licensed under the MIT License. You may obtain a copy 
 * of this license in the LICENSE file in the root directory of this source tree 
 * or at https://github.com/javpelle/TFGInformatica/blob/master/LICENSE.
 */

package model.test;

import model.testresult.OutputTestResult;
import model.testresult.TestResult;

/**
 * Concrete Test which represents a "Montecarlo" type of test.
 * 
 * @author Javier & Luis.
 *
 */
public class OutputTest extends Test {

	private int shots;

	/**
	 * Constructor for the class.
	 */
	public OutputTest() {
		shots = 0;
	}

	@Override
	public int getIDTest() {
		return 2;
	}

	@Override
	public String getNameTest() {
		return "Output Test";
	}

	@Override
	public void setShots(int shots) {
		this.shots = shots;
	}

	@Override
	public int getShots() {
		return shots;
	}

	@Override
	public TestResult newTestResult(String mutantName, int idTest) {
		return new OutputTestResult(mutantName, idTest);
	}

}
