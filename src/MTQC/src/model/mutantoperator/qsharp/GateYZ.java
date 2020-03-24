package model.mutantoperator.qsharp;

public class GateYZ extends QSharpGate {
	@Override
	public String getName() {
		return "GateY_GateZ";
	}

	@Override
	public String getDescription() {
		return "Replace Y gate with Z gate.";
	}

	@Override
	public String getSearchOperator() {
		return "Y(";
	}

	@Override
	public String getMutantOperator() {
		return "Z(";
	}

}
