package model.mutantoperator.qiskit;

public class CHSWAPGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCH_GateSWAP";
	}

	@Override
	public String getDescription() {
		return "Replace CH gate with SWAP gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ch(";
	}

	@Override
	public String getMutantOperator() {
		return ".swap(";
	}

}