package model.mutantoperator.qsharp;

public class GateYH extends QSharpGate {
	@Override
	public String getName() {
		return "GateY_GateH";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with Hadamard gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Y(";
	}

	@Override
	public String getMutantOperator() {
		return "H(";
	}

}
