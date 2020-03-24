package model.mutantoperator.qsharp;

public class GateST extends QSharpGate {
	@Override
	public String getName() {
		return "GateS_GateT";
	}

	@Override
	public String getDescription() {
		return "Replace S gate with T gate.";
	}

	@Override
	public String getSearchOperator() {
		return "S(";
	}

	@Override
	public String getMutantOperator() {
		return "T(";
	}

}
