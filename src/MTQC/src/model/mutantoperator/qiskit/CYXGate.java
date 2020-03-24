package model.mutantoperator.qiskit;

public class CYXGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCY_GateCX";
	}

	@Override
	public String getDescription() {
		return "Replace CY gate with CX gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cy(";
	}

	@Override
	public String getMutantOperator() {
		return ".cx(";
	}

}