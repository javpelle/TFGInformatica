package model.mutantoperator.qiskit;

public class SdgSGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateSdg_GateS";
	}

	@Override
	public String getDescription() {
		return "Replace Sdg gate with S gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".sdg(";
	}

	@Override
	public String getMutantOperator() {
		return ".s(";
	}

}