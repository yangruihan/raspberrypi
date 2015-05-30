package com.yrh.tool;

import java.util.EmptyStackException;
import java.util.Stack;

public class CaculateFunction {

	private static String[] TrnsInToSufix(String IFX)// PFX放后缀表达式，IFX为中缀表达式
	{
		String PFX[] = new String[IFX.length()];
		StringBuffer numBuffer = new StringBuffer();// 用来保存一个数的
		Stack<String> s = new Stack<String>();// 放操作符
		String a;
		// s.push("=");// 第一个为等号
		int i = 0, j = 0;
		char ch;
		for (i = 0; i < IFX.length() - 1;) {
			ch = IFX.charAt(i);
			switch (ch) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				while (Character.isDigit(ch) || ch == '.')// 拼数
				{
					numBuffer.append(ch); // 追加字符
					ch = IFX.charAt(++i);
				}
				PFX[j++] = numBuffer.toString();// break;
				numBuffer = new StringBuffer(); // 清空已获取的运算数字
				continue; // 这里要重新循环，因为i已经增加过了
			case '(':
				s.push("(");
				break;
			case ')':
				while (s.peek() != "(")
					PFX[j++] = s.pop();
				s.pop();
				break;
			case '+':
			case '-':
				while (s.size() >= 1
						&& (s.peek().equals("*") || s.peek().equals("/")
								|| s.peek().equals("s") || s.peek().equals("c")
								|| s.peek().equals("t") || s.peek().equals("^") || s
								.peek().equals("√")))
					PFX[j++] = s.pop();
				a = String.valueOf(ch);
				s.push(a);
				break;
			case '*':
			case '/':
				while (s.size() >= 1
						&& (s.peek().equals("*") || s.peek().equals("/")
								|| s.peek().equals("s") || s.peek().equals("c")
								|| s.peek().equals("t") || s.peek().equals("^") || s
								.peek().equals("√")))
					PFX[j++] = s.pop();
				a = String.valueOf(ch);
				s.push(a);
				break;
			case 's':
			case 'c':
			case 't':// 三角函数
				while (s.size() >= 1
						&& (s.peek().equals("s") || s.peek().equals("c")
								|| s.peek().equals("t") || s.peek().equals("^") || s
								.peek().equals("√")))
					// 优先级比较，与栈顶，大于等于的弹出
					PFX[j++] = s.pop();
				a = String.valueOf(ch);
				s.push(a);
				break;
			case '^':// 幂
			case '√':// 开方
				while (s.size() >= 1
						&& (s.peek().equals("^") || s.peek().equals("√")))
					PFX[j++] = s.pop();
				a = String.valueOf(ch);
				s.push(a);
				break;
			}
			i++;
		}
		while (s.size() >= 1)
			PFX[j++] = s.pop();
		PFX[j] = "=";

		for (i = 0; i < PFX.length; i++) {
			if (PFX[i] == null) {
				break;
			}
			System.out.println(PFX[i]);
		}

		return PFX;
	}

	public static String Evaluate(String IFX)// 后缀表达式求值
	{
		String PFX[] = null;
		try {
			PFX = TrnsInToSufix(IFX);
		} catch (EmptyStackException e) {
			return "syntax error";
		}
		int i = 0;
		double x1, x2, n;
		String str;
		Stack<String> s = new Stack<String>();
		while (PFX[i] != "=") {
			str = PFX[i];
			switch (str.charAt(0)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				s.push(str);
				break;
			case '+':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = x1 + x2;
				s.push(String.valueOf(n));
				break;
			case '-':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = x2 - x1;
				s.push(String.valueOf(n));
				break;
			case '*':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = x1 * x2;
				s.push(String.valueOf(n));
				break;
			case '/':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = x2 / x1;
				s.push(String.valueOf(n));
				break;
			case 's':
				x1 = Double.parseDouble(s.pop());
				n = Math.sin(x1 * Math.PI / 180);
				s.push(String.valueOf(n));
				break;
			case 'c':
				x1 = Double.parseDouble(s.pop());
				n = Math.cos(x1 * Math.PI / 180);
				s.push(String.valueOf(n));
				break;
			case 't':
				x1 = Double.parseDouble(s.pop());
				n = Math.tan(x1 * Math.PI / 180);
				s.push(String.valueOf(n));
				break;
			case '√':
				x1 = Double.parseDouble(s.pop());
				n = Math.sqrt(x1);
				s.push(String.valueOf(n));
				break;// 开方
			case '^':
				x1 = Double.parseDouble(s.pop());
				x2 = Double.parseDouble(s.pop());
				n = Math.pow(x2, x1);
				s.push(String.valueOf(n));
				break;
			}
			i++;
		}
		String result = s.pop();
		return result;
	}

}
