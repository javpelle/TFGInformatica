package model.mutantoperator.qiskit;

public class SdgZGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateSdg_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace Sdg gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".sdg(";
	}

	@Override
	public String getMutantOperator() {
		return ".z(";
	}

}