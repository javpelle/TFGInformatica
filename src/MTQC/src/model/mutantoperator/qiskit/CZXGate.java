package model.mutantoperator.qiskit;

public class CZXGate extends QiskitGate {
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