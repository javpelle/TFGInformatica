package model.mutantoperator.qiskit;

public class CZHGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCZ_GateCH";
	}

	@Override
	public String getDescription() {
		return "Replace CZ gate with CH gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cz(";
	}

	@Override
	public String getMutantOperator() {
		return ".ch(";
	}

}