package model.mutantoperator.qiskit;

public class TSdgGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateT_GateSdg";
	}

	@Override
	public String getDescription() {
		return "Replace T gate with Sdg gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".t(";
	}

	@Override
	public String getMutantOperator() {
		return ".sdg(";
	}

}