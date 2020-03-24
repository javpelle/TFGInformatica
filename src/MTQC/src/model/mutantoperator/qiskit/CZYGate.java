package model.mutantoperator.qiskit;

public class CZYGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCZ_GateCY";
	}

	@Override
	public String getDescription() {
		return "Replace CZ gate with CY gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cz(";
	}

	@Override
	public String getMutantOperator() {
		return ".cy(";
	}

}