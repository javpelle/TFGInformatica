package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CZSWAPGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCZ_GateSWAP";
	}

	@Override
	public String getDescription() {
		return "Replace CZ gate with SWAP gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cz(";
	}

	@Override
	public String getMutantOperator() {
		return ".swap(";
	}

}