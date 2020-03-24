package model.mutantoperator.qsharp;

public class GateXZ extends QSharpGate {
	@Override
	public String getName() {
		return "GateX_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace X gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return "X(";
	}

	@Override
	public String getMutantOperator() {
		return "Z(";
	}

}
