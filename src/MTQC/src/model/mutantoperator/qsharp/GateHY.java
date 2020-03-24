package model.mutantoperator.qsharp;

public class GateHY extends QSharpGate {
	@Override
	public String getName() {
		return "GateH_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace Hadamard gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return "H(";
	}

	@Override
	public String getMutantOperator() {
		return "Y(";
	}

}
