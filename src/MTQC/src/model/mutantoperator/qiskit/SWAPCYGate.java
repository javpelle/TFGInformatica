package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class SWAPCYGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateSWAP_GateCY";
	}

	@Override
	public String getDescription() {
		return "Replace SWAP gate with CY gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".swap(";
	}

	@Override
	public String getMutantOperator() {
		return ".cy(";
	}

}