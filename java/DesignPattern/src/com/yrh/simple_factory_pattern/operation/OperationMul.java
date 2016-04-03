package com.yrh.simple_factory_pattern.operation;

/**
 * 乘法运算类
 * @author Yrh
 *
 */
public class OperationMul extends Operation {

	@Override
	public double getResult() {
		double result = 0;
		result = getNumberA() * getNumberB();
		return result;
	}
}
