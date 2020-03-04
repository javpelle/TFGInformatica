package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class SWAPCXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateSWAP_GateCX";
	}

	@Override
	public String getDescription() {
		return "Replace SWAP gate with CX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".swap(";
	}

	@Override
	public String getMutantOperator() {
		return ".cx(";
	}

}