package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class SWAPCZGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateSWAP_GateCZ";
	}

	@Override
	public String getDescription() {
		return "Replace SWAP gate with CZ gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".swap(";
	}

	@Override
	public String getMutantOperator() {
		return ".cz(";
	}

}