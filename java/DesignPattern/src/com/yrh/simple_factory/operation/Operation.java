package com.yrh.simple_factory.operation;

/**
 * 运算抽象类
 * @author Yrh
 *
 */
public abstract class Operation {
	private double numberA = 0;
	private double numberB = 0;
	
	public double getResult() {
		return 0.0;
	}
	
	/* get && set */
	public double getNumberA() {
		return numberA;
	}
	public void setNumberA(double numberA) {
		this.numberA = numberA;
	}
	public double getNumberB() {
		return numberB;
	}
	public void setNumberB(double numberB) {
		this.numberB = numberB;
	}
}
