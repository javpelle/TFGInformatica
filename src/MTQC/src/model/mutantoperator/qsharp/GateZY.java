package model.mutantoperator.qsharp;

public class GateZY extends QSharpGate {
	@Override
	public String getName() {
		return "GateZ_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Z(";
	}

	@Override
	public String getMutantOperator() {
		return "Y(";
	}

}
