package com.yrh.simple_factory.operation;

/**
 * 减法运算类
 * @author Yrh
 *
 */
public class OperationSub extends Operation {

	@Override
	public double getResult() {
		double result = 0;
		result = getNumberA() - getNumberB();
		return result;
	}
}
