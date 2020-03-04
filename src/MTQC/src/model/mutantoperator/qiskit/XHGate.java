package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class XHGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateX_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace X gate with H gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".x(";
	}

	@Override
	public String getMutantOperator() {
		return ".h(";
	}

}