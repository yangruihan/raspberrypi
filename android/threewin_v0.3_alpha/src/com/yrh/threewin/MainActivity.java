package com.yrh.threewin;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private GameView gameView; // ��Ϸ��ͼ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ���� Activity ��ӵ�ϵͳ��������
		SysApplication.getInstance().addActivity(this);

		setContentView(R.layout.activity_main);

//		gameView = (GameView) findViewById(R.id.gameView);
//		 int[][] tempMap = { { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 },
//		 { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 },
//		 { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };
//		gameView.setGame(6, 6, 6, tempMap);

	}
}
