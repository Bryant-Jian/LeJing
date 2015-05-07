package com.lejing.renshi.user;

import org.apache.cordova.DroidGap;

import android.os.Bundle;

@SuppressWarnings("deprecation")
public class LoginActivity extends DroidGap  {
	
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		super.loadUrl("file:///android_asset/www.famibao.cn/view/user/userlogin.html");
	}

}
