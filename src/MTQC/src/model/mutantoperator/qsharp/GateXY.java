package model.mutantoperator.qsharp;

public class GateXY extends QSharpGate {
	@Override
	public String getName() {
		return "GateX_GateY";
	}

	@Override
	public String getDescription() {
		return "Replace X gate with Y gate.";
	}

	@Override
	public String getSearchOperator() {
		return "X(";
	}

	@Override
	public String getMutantOperator() {
		return "Y(";
	}

}
