package model.mutantoperator.qiskit;

public class SWAPCZGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateSWAP_GateCZ";
	}

	@Override
	public String getDescription() {
		return "Replace SWAP gate with CZ gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".swap(";
	}

	@Override
	public String getMutantOperator() {
		return ".cz(";
	}

}