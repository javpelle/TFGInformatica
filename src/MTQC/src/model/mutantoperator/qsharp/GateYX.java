package model.mutantoperator.qsharp;

public class GateYX extends QSharpGate {
	@Override
	public String getName() {
		return "GateY_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with X gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Y(";
	}

	@Override
	public String getMutantOperator() {
		return "X(";
	}

}
