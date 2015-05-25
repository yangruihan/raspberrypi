package com.yrh.threewin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MenuActivity extends Activity implements OnClickListener {

	private ImageButton btn_start;
	private ImageButton btn_about;
	private ImageButton btn_quit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ���� Activity ��ӵ�ϵͳ��������
		SysApplication.getInstance().addActivity(this);
		// ���ò˵�����
		setContentView(R.layout.activity_menu);

		// ��ʼ���ؼ�
		initView();
	}

	private void initView() {
		btn_start = (ImageButton) findViewById(R.id.btn_start);
		btn_about = (ImageButton) findViewById(R.id.btn_about);
		btn_quit = (ImageButton) findViewById(R.id.btn_quit);
		btn_start.setOnClickListener(this);
		btn_about.setOnClickListener(this);
		btn_quit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// �����ʼ��Ϸ��ť
		case R.id.btn_start:
			// ���� Activity ��ת
			Intent intent = new Intent();
			intent.setClass(MenuActivity.this, MainActivity.class);
			startActivity(intent);
			break;
		// ������ڰ�ť
		case R.id.btn_about:

			break;
		// ����˳���Ϸ��ť
		case R.id.btn_quit:
			// ����һ���˳��ĶԻ���
			creatExitDialog();
			break;

		default:
			break;
		}
	}

	/**
	 * ����һ���˳��ĶԻ���
	 */
	private void creatExitDialog() {
		// ����һ���˳��ĶԻ���
		AlertDialog exitDialog = new AlertDialog.Builder(MenuActivity.this)
				.setTitle("ȷ��Ҫ�˳���")
				.setPositiveButton("�˳�", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						SysApplication.getInstance().exit();
					}

				})
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				}).create();
		// ���˳��ĶԻ�����ʾ����
		exitDialog.show();
	}

}
