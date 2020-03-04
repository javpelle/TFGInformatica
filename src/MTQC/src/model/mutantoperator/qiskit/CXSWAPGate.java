package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CXSWAPGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCX_GateSWAP";
	}

	@Override
	public String getDescription() {
		return "Replace CX gate with SWAP gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cx(";
	}

	@Override
	public String getMutantOperator() {
		return ".swap(";
	}

}