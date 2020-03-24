package model.mutantoperator.qiskit;

public class SWAPCXGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateSWAP_GateCX";
	}

	@Override
	public String getDescription() {
		return "Replace SWAP gate with CX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".swap(";
	}

	@Override
	public String getMutantOperator() {
		return ".cx(";
	}

}