package com.lejing.renshi.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class SendMessageBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		Bundle b = intent.getExtras();
		Toast.makeText(context, "action = " + action + " extras = { " + 
				b.getString("name") + ", "+ b.getString("bb"),  Toast.LENGTH_LONG).show();
	}

}
