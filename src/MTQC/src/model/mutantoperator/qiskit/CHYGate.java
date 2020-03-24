package model.mutantoperator.qiskit;

public class CHYGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCH_GateCY";
	}

	@Override
	public String getDescription() {
		return "Replace CH gate with CY gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ch(";
	}

	@Override
	public String getMutantOperator() {
		return ".cy(";
	}

}