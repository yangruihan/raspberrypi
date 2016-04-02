package com.yrh.simple_factory;

import com.yrh.simple_factory.operation.Operation;
import com.yrh.simple_factory.operation.OperationAdd;
import com.yrh.simple_factory.operation.OperationDiv;
import com.yrh.simple_factory.operation.OperationMul;
import com.yrh.simple_factory.operation.OperationPow;
import com.yrh.simple_factory.operation.OperationSub;

/**
 * 运算符工厂
 * @author Yrh
 *
 */
public class OperationFactory {

	/**
	 * 根据传入运算符创建相应的运算类
	 * @param operate 运算符
	 * @return 运算类
	 */
	public static Operation createOperate(String operate) {
		Operation oper = null;
		switch (operate) {
		case "+":
			oper = new OperationAdd();
			break;
		case "-":
			oper = new OperationSub();
			break;
		case "*":
			oper = new OperationMul();
			break;
		case "/":
			oper = new OperationDiv();
			break;
		case "^":
			oper = new OperationPow();
			break;
		default:
			break;
		}
		return oper;
	}
	
}
