package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CYSWAPGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCY_GateSWAP";
	}

	@Override
	public String getDescription() {
		return "Replace CY gate with SWAP gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cy(";
	}

	@Override
	public String getMutantOperator() {
		return ".swap(";
	}

}