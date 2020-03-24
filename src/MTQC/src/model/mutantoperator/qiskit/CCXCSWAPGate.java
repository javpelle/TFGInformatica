package model.mutantoperator.qiskit;

public class CCXCSWAPGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCCX_GateCSWAP";
	}

	@Override
	public String getDescription() {
		return "Replace CCX gate with CSWAP gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ccx(";
	}

	@Override
	public String getMutantOperator() {
		return ".cswap(";
	}

}