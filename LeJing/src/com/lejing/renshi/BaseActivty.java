package com.lejing.renshi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lejing.renshi.common.SessionManager;

public class BaseActivty extends ActionBarActivity {

	public ImageView leftImage, rightImage;
	public static SessionManager session = null;

	public LinearLayout leftLayout, rightLayout, rightTextLayout, titleLayout;
	public TextView titleName;
	public TextView titleRight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setCustomView(R.layout.title_titlbar);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setDisplayShowCustomEnabled(true);

	}

	
}
