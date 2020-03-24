package model.mutantoperator.qsharp;

public class GateTS extends QSharpGate {
	@Override
	public String getName() {
		return "GateT_GateS";
	}

	@Override
	public String getDescription() {
		return "Replace T( gate with S gate.";
	}

	@Override
	public String getSearchOperator() {
		return "T(";
	}

	@Override
	public String getMutantOperator() {
		return "S(";
	}

}
