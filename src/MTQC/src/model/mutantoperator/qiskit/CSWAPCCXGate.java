package model.mutantoperator.qiskit;

public class CSWAPCCXGate extends QiskitGate {
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