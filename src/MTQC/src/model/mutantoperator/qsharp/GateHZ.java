package model.mutantoperator.qsharp;

public class GateHZ extends QSharpGate {
	@Override
	public String getName() {
		return "GateH_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace Hadamard gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return "H(";
	}

	@Override
	public String getMutantOperator() {
		return "Z(";
	}

}
