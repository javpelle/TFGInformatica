package model.mutantoperator.qiskit;

public class CHZGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCH_GateCZ";
	}

	@Override
	public String getDescription() {
		return "Replace CH gate with CZ gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ch(";
	}

	@Override
	public String getMutantOperator() {
		return ".cz(";
	}

}