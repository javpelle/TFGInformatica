package model.mutantoperator.qiskit;

public class SWAPCHGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateSWAP_GateCH";
	}

	@Override
	public String getDescription() {
		return "Replace SWAP gate with CH gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".swap(";
	}

	@Override
	public String getMutantOperator() {
		return ".ch(";
	}

}