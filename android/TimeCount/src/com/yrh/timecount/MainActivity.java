package com.yrh.timecount;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText et_inputTime;
	private Button btn_getTime, btn_start, btn_pause, btn_record, btn_clear;
	private TextView tv_showTime;
	private int int_time;
	private Timer timer;
	private TimerTask timerTask;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (int_time > 0) {
				tv_showTime.setText(int_time
						/ 1000
						+ "."
						+ ((int_time % 1000 / 10) < 10 ? "0"
								+ (int_time % 1000 / 10)
								: (int_time % 1000 / 10)));
				startTime();
			} else {
				tv_showTime.setText("0.00");
				pauseTime();
			}
		}
	};
	private ListView lv_record;
	private ArrayList<String> recordList = new ArrayList<String>();

	// 开始计时
	private void startTime() {
		timer = new Timer();
		timerTask = new TimerTask() {

			@Override
			public void run() {
				int_time -= 10;
				Message message = handler.obtainMessage();
				message.arg1 = int_time;
				handler.sendMessage(message);
			}
		};
		timer.schedule(timerTask, 10);
	}

	// 暂停计时
	private void pauseTime() {
		timer.cancel();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 初始化 view
		initView();
	}

	// 清空计时
	private void clearTime() {

	}

	// 初始化 View
	private void initView() {
		et_inputTime = (EditText) findViewById(R.id.et_inputTime);
		btn_getTime = (Button) findViewById(R.id.btn_getTime);
		btn_start = (Button) findViewById(R.id.btn_start);
		btn_pause = (Button) findViewById(R.id.btn_pause);
		btn_record = (Button) findViewById(R.id.btn_record);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		tv_showTime = (TextView) findViewById(R.id.tv_showTime);
		lv_record = (ListView) findViewById(R.id.lv_record);
		btn_getTime.setOnClickListener(this);
		btn_start.setOnClickListener(this);
		btn_pause.setOnClickListener(this);
		btn_record.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_getTime:
			if (et_inputTime.getText().toString().equals("")) {
				Toast.makeText(this, "请输入一个时间(单位：s)", Toast.LENGTH_SHORT)
						.show();
				return;
			}
			if (tv_showTime.getVisibility() == TextView.INVISIBLE) {
				tv_showTime.setVisibility(TextView.VISIBLE);
			}
			tv_showTime.setText(et_inputTime.getText().toString());
			int_time = Integer.parseInt(et_inputTime.getText().toString()) * 1000;
			break;

		case R.id.btn_start:
			if (int_time == 0) {
				Toast.makeText(this, "请输入一个时间(单位：s)", Toast.LENGTH_SHORT)
						.show();
				return;
			}
				startTime();
			break;

		case R.id.btn_pause:
			pauseTime();
			break;

		case R.id.btn_clear:
			timer.cancel();
			int_time = 0;
			recordList.clear();
			lv_record
					.setAdapter(new ArrayAdapter<String>(this,
							android.R.layout.simple_expandable_list_item_1,
							recordList));
			et_inputTime.setText("");
			tv_showTime.setText("");
			btn_start.setText("开始");
			break;

		case R.id.btn_record:
			updateDate();
			break;

		default:
			break;
		}
	}

	private void updateDate() {
		recordList.add(int_time
				/ 1000
				+ "."
				+ ((int_time % 1000 / 10) < 10 ? "0" + (int_time % 1000 / 10)
						: (int_time % 1000 / 10)));
		lv_record.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, recordList));

	}
}
