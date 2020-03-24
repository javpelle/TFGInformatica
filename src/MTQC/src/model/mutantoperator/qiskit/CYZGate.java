package model.mutantoperator.qiskit;

public class CYZGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCY_GateCZ";
	}

	@Override
	public String getDescription() {
		return "Replace CY gate with CZ gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cy(";
	}

	@Override
	public String getMutantOperator() {
		return ".cz(";
	}

}