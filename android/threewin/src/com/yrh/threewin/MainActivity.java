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

		gameView = (GameView) findViewById(R.id.gameView);
//		int[][] tempMap = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
//				{ 1, 1, 1, 1, 1, 1, 1 } };
//		gameView.setGame(7, 7, 6, tempMap);

		// gameView.setNumberX(7);
		// gameView.setNumberY(7);
		// int[][] tempMap = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
		// { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
		// { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
		// { 1, 1, 1, 1, 1, 1, 1 } };
		// gameView.setMap(tempMap);
		// gameView.setKindOfObj(6);
		gameView.invalidate();

	}
}
