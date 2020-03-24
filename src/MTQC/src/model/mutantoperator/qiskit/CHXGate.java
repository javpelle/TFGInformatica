package model.mutantoperator.qiskit;

public class CHXGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCH_GateCX";
	}

	@Override
	public String getDescription() {
		return "Replace CH gate with CX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".ch(";
	}

	@Override
	public String getMutantOperator() {
		return ".cx(";
	}

}