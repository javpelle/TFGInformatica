package model.mutantoperator.qsharp;

public class GateZX extends QSharpGate {
	@Override
	public String getName() {
		return "GateZ_GateX";
	}

	@Override
	public String getDescription() {
		return "Replace Z gate with X gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Z(";
	}

	@Override
	public String getMutantOperator() {
		return "X(";
	}

}
