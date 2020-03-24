package model.mutantoperator.qiskit;

public class CYHGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCY_GateCH";
	}

	@Override
	public String getDescription() {
		return "Replace CY gate with CH gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cy(";
	}

	@Override
	public String getMutantOperator() {
		return ".ch(";
	}

}