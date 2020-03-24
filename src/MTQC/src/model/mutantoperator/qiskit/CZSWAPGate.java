package model.mutantoperator.qiskit;

public class CZSWAPGate extends QiskitGate {
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