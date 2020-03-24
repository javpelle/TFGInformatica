package model.mutantoperator.qsharp;

public class GateZH extends QSharpGate {
	@Override
	public String getName() {
		return "GateZ_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with Hadamard gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Z(";
	}

	@Override
	public String getMutantOperator() {
		return "H(";
	}

}
