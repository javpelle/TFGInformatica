package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CZXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCZ_GateCX";
	}

	@Override
	public String getDescription() {
		return "Replace CZ gate with CX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cz(";
	}

	@Override
	public String getMutantOperator() {
		return ".cx(";
	}

}