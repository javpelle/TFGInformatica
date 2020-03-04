package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CHXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCH_GateCX";
	}

	@Override
	public String getDescription() {
		return "Replace CH gate with CX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ch(";
	}

	@Override
	public String getMutantOperator() {
		return ".cx(";
	}

}