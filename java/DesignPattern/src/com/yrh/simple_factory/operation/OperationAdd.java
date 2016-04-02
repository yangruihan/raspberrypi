package com.yrh.simple_factory.operation;

/**
 * 加法运算类
 * @author Yrh
 *
 */
public class OperationAdd extends Operation {

	@Override
	public double getResult() {
		double result;
		result = getNumberA() + getNumberB();
		return result;
	}
}
