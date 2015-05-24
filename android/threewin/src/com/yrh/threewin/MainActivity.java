package com.yrh.threewin;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	private GameView gameView; // ”Œœ∑ ”Õº¿‡

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gameView = (GameView) findViewById(R.id.gameView);
	}

}
