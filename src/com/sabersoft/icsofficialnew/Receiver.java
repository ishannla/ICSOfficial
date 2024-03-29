package com.sabersoft.icsofficialnew;

import android.content.Context;
import android.content.Intent;

import com.parse.ParsePushBroadcastReceiver;

public class Receiver extends ParsePushBroadcastReceiver {

	//Enable Push Notifications
    @Override
    public void onPushOpen(Context context, Intent intent) {
        Intent i = new Intent(context, SplashScreen.class);
        i.putExtras(intent.getExtras());
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}