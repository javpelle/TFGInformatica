package model.mutantoperator.qiskit;

import model.mutantoperator.MutantOperator;

public class CSWAPCCXGate extends MutantOperator {
	@Override
	public String getName() {
		return "GateCSWAP_GateCCX";
	}

	@Override
	public String getDescription() {
		return "Replace CSWAP gate with CCX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cswap(";
	}

	@Override
	public String getMutantOperator() {
		return ".ccx(";
	}

}