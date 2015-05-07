package com.lejing.renshi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class FirstActivity extends ActionBarActivity {

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		Intent intent = new Intent();
		intent.setClass(FirstActivity.this, MainActivity.class);
		startActivity(intent);
	}
}
