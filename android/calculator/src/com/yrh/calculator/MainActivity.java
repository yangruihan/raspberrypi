package com.yrh.calculator;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.yrh.tool.Util;

public class MainActivity extends Activity implements OnClickListener {

	private TextView tv_input;
	private TextView tv_result;

	private Button[] btn_num = new Button[10]; // 数字键
	private Button btn_clear; // 清除键
	private Button btn_div; // 除法
	private Button btn_mul; // 乘法
	private Button btn_del; // 清除键
	private Button btn_dec; // 减法
	private Button btn_inc; // 加法
	private Button btn_brac; // 括号
	private Button btn_equ; // 等号
	private Button btn_point; // 小数点
	private Button btn_plusMinus; // 正负号
	private String calStr = ""; // 用于记录当前数值的字符串
	private ArrayList<String> list = new ArrayList<String>(); // 用于存储每一个数和符号
	private int numberOfBrac; // 括号数量
	private String resStr = ""; // 用于记录结果的字符串
	public static ArrayList<String> historyList = new ArrayList<String>(); // 历史记录

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 初始化控件
		init();
	}

	/**
	 * 初始化控件
	 */
	private void init() {

		tv_input = (TextView) findViewById(R.id.tv_input);
		tv_result = (TextView) findViewById(R.id.tv_result);

		btn_num[0] = (Button) findViewById(R.id.btn_0);
		btn_num[1] = (Button) findViewById(R.id.btn_1);
		btn_num[2] = (Button) findViewById(R.id.btn_2);
		btn_num[3] = (Button) findViewById(R.id.btn_3);
		btn_num[4] = (Button) findViewById(R.id.btn_4);
		btn_num[5] = (Button) findViewById(R.id.btn_5);
		btn_num[6] = (Button) findViewById(R.id.btn_6);
		btn_num[7] = (Button) findViewById(R.id.btn_7);
		btn_num[8] = (Button) findViewById(R.id.btn_8);
		btn_num[9] = (Button) findViewById(R.id.btn_9);
		btn_brac = (Button) findViewById(R.id.btn_brac);
		btn_point = (Button) findViewById(R.id.btn_point);
		btn_plusMinus = (Button) findViewById(R.id.btn_plus_minus);
		btn_equ = (Button) findViewById(R.id.btn_equ);
		btn_inc = (Button) findViewById(R.id.btn_inc);
		btn_dec = (Button) findViewById(R.id.btn_dec);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_mul = (Button) findViewById(R.id.btn_mul);
		btn_div = (Button) findViewById(R.id.btn_div);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		for (int i = 0; i < 10; i++) {
			btn_num[i].setOnClickListener(this);
		}
		btn_brac.setOnClickListener(this);
		btn_point.setOnClickListener(this);
		btn_plusMinus.setOnClickListener(this);
		btn_equ.setOnClickListener(this);
		btn_inc.setOnClickListener(this);
		btn_dec.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_mul.setOnClickListener(this);
		btn_div.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.history) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_0:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "0";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_1:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "1";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_2:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "2";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_3:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "3";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_4:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "4";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_5:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "5";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_6:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "6";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_7:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "7";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_8:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "8";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_9:
			// 初始化结果栏
			init_tv_result();
			if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "";
			}
			calStr += "9";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_clear: // 清空按钮
			calStr = "";
			list.clear();
			numberOfBrac = 0;
			tv_input.setText("");
			tv_result.setText("");
			break;
		case R.id.btn_inc:
			// 如果当前字符串最后一个字符是运算符
			if (list.size() == 0 && calStr.equals("") || Util.lastIsOpt(calStr)) {
				return;
			}

			// 如果当前字符串最后一位是小数点
			if (Util.lastIsPoint(calStr)) {
				calStr = calStr.substring(0, calStr.length() - 1);
			}
			list.add(calStr);
			calStr = "+";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_dec:
			// 如果当前字符串最后一个字符是运算符
			if (list.size() == 0 && calStr.equals("") || Util.lastIsOpt(calStr)) {
				return;
			}

			// 如果当前字符串最后一位是小数点
			if (Util.lastIsPoint(calStr)) {
				calStr = calStr.substring(0, calStr.length() - 1);
			}
			list.add(calStr);
			calStr = "-";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_mul:
			// 如果当前字符串最后一个字符是运算符
			if (list.size() == 0 && calStr.equals("") || Util.lastIsOpt(calStr)) {
				return;
			}

			// 如果当前字符串最后一位是小数点
			if (Util.lastIsPoint(calStr)) {
				calStr = calStr.substring(0, calStr.length() - 1);
			}
			list.add(calStr);
			calStr = "*";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_div:
			// 如果当前字符串最后一个字符是运算符
			if (list.size() == 0 && calStr.equals("") || Util.lastIsOpt(calStr)) {
				return;
			}

			// 如果当前字符串最后一位是小数点
			if (Util.lastIsPoint(calStr)) {
				calStr = calStr.substring(0, calStr.length() - 1);
			}
			list.add(calStr);
			calStr = "/";
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_point:
			// 初始化结果栏
			init_tv_result();
			// 如果已经含有小数点了，则直接返回
			if (calStr.contains(".")) {
				return;
			}
			if (calStr.equals("")) {
				calStr = "0.";
			} else if (Util.lastIsOpt(calStr)) {
				list.add(calStr);
				calStr = "0.";
			} else {
				calStr += ".";
			}
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_del: // 退格按钮
			if (calStr.equals("") && list.size() == 0) {
				return;
			} else if (calStr.equals("") && list.size() > 0) {
				calStr = list.get(list.size() - 1);
				list.remove(list.size() - 1);
			}
			if (calStr.equals("(")) {
				numberOfBrac--;
			}
			if (calStr.startsWith("(-")) {
				calStr = calStr.substring(calStr.indexOf("-") + 1,
						calStr.indexOf(")"));
			} else {
				calStr = calStr.substring(0, calStr.length() - 1);
			}
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_brac: // 括号按钮
			// 初始化结果栏
			init_tv_result();
			if (numberOfBrac > 0 && !Util.lastIsOpt(calStr)
					&& !list.get(list.size() - 1).equals("(")) {
				numberOfBrac--;
				list.add(calStr);
				list.add(")");
				calStr = "";
			} else if (Util.lastIsOpt(calStr)
					|| list.get(list.size() - 1).equals("(")) {
				numberOfBrac++;
				list.add(calStr);
				list.add("(");
				calStr = "";
			} else if (list.size() == 0 && calStr.equals("")) {
				numberOfBrac++;
				list.add("(");
			} else {
				return;
			}
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_plus_minus: // 正负号
			if (Util.lastIsOpt(calStr) || calStr.equals("")) {
				return;
			}
			if (calStr.startsWith("(-")) {
				calStr = calStr.substring(calStr.indexOf("-") + 1,
						calStr.indexOf(")"));
			} else {
				calStr = "(-" + calStr + ")";
			}
			tv_input.setText(Util.getFormatNumber(list)
					+ Util.getFormatNumber(calStr));
			break;
		case R.id.btn_equ: // 等号
			if (list.isEmpty()) {
				return;
			}
			if (numberOfBrac > 0) {
				tv_result.setText("格式错误，无法计算");
			}
			// 自动忽略最后一个未完成的运算符
			if (Util.lastIsOpt(calStr)) {
				calStr = "";
			}
			if (!calStr.equals("")) {
				list.add(calStr);
			}
			tv_input.setText(Util.getFormatNumber(list));
			resStr = Util.calculate(list);
			if (resStr.equals("Infinity")) {
				tv_result.setText("被除数不能为0");
			} else if (!resStr.equals("")) {
				tv_result.setText(Util.getFormatNumber(resStr));
				// 记录历史记录
				historyList.add("原式：" + Util.getFormatNumber(list) + " 结果：" + Util.getFormatNumber(resStr));
			}

			calStr = "";
			list.clear();
			break;
		default:
			break;
		}
	}

	private void init_tv_result() {
		if (!tv_result.getText().equals("")) {
			tv_result.setText("");
		}
	}
}
