package model.mutantoperator.qiskit;

public class CXHGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCX_GateCH";
	}

	@Override
	public String getDescription() {
		return "Replace CX gate with CH gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cx(";
	}

	@Override
	public String getMutantOperator() {
		return ".ch(";
	}

}