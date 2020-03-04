package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class SWAPCHGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateSWAP_GateCH";
	}

	@Override
	public String getDescription() {
		return "Replace SWAP gate with CH gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".swap(";
	}

	@Override
	public String getMutantOperator() {
		return ".ch(";
	}

}