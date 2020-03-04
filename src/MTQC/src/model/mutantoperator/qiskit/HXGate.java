package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class HXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateH_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace H gate with X gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".h(";
	}

	@Override
	public String getMutantOperator() {
		return ".x(";
	}

}