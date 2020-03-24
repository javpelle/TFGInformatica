package model.mutantoperator.qiskit;

public class CXYGate extends QiskitGate {
	@Override
	public String getName() {
		return "GateCX_GateCY";
	}

	@Override
	public String getDescription() {
		return "Replace CX gate with CY gate.";
	}

	@Override
	public String getSearchOperator() {
		return ".cx(";
	}

	@Override
	public String getMutantOperator() {
		return ".cy(";
	}

}