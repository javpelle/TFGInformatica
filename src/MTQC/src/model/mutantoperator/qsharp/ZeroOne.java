package model.mutantoperator.qsharp;

public class ZeroOne extends QSharpConstant {
	@Override
	public String getName() {
		return "Zero_One";
	}

	@Override
	public String getDescription() {
		return "Replace Zero constant with One constant.";
	}

	@Override
	public String getSearchOperator() {
		return "Zero";
	}

	@Override
	public String getMutantOperator() {
		return "One";
	}

}
