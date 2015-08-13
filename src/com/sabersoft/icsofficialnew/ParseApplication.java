package com.sabersoft.icsofficialnew;

import android.app.Application;

import com.parse.Parse;
import com.parse.PushService;

public class ParseApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		//Assign unique Parse ID to connect to Parse Servers (used as Backend)
		Parse.initialize(this, "9huJudUqy65ckF5UicJ3oKQqnt8ILSIWxAjqZxQG", "WQX8Qgqnp5IhR44JDEQYpBGOyS64aYntf0jlstKG");
		PushService.setDefaultPushCallback(this, SplashScreen.class);
		
	}
	
}
