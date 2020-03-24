package model.mutantoperator.qiskit;

public class CYSWAPGate extends QiskitGate {
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