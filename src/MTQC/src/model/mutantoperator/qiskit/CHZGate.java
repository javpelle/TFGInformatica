package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CHZGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCH_GateCZ";
	}

	@Override
	public String getDescription() {
		return "Replace CH gate with CZ gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ch(";
	}

	@Override
	public String getMutantOperator() {
		return ".cz(";
	}

}