package model.mutantoperator.qsharp;

public class GateHX extends QSharpGate {
	@Override
	public String getName() {
		return "GateH_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace Hadamard gate with X gate.";
	}

	public String getSearchOperator() {
		return "H(";
	}

	@Override
	public String getMutantOperator() {
		return "X(";
	}

}
