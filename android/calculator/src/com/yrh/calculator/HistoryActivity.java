package com.yrh.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HistoryActivity extends Activity {

	private ListView lv;
	private Button btn_clear;
	private Button btn_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_history);

		lv = (ListView) findViewById(R.id.lv_history);
		lv.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1,
				MainActivity.historyList));

		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_back = (Button) findViewById(R.id.btn_back);
		btn_clear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Çå³ý¼ÇÂ¼
				MainActivity.cleanHistory();
				lv.setAdapter(new ArrayAdapter<String>(HistoryActivity.this,
						android.R.layout.simple_expandable_list_item_1,
						MainActivity.historyList));
			}
		});
		
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
