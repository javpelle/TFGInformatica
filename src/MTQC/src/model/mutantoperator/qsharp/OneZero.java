package model.mutantoperator.qsharp;

public class OneZero extends QSharpConstant {
	@Override
	public String getName() {
		return "One_Zero";
	}

	@Override
	public String getDescription() {
		return "Replace One constant with Zero constant.";
	}

	@Override
	public String getSearchOperator() {
		return "One";
	}

	@Override
	public String getMutantOperator() {
		return "Zero";
	}

}
