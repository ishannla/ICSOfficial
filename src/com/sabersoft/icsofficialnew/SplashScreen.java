
package com.sabersoft.icsofficialnew;



import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Window;
import android.widget.TextView;

import com.parse.ParseUser;

public class SplashScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.splashscreen);
		TextView motto  = (TextView) findViewById(R.id.textView1);
		String htmlString="<u>Home of the Phoenix</u>";
		motto.setText(Html.fromHtml(htmlString));
		setProgressBarVisibility(true);
	
		//Assign the Splash Screen to run for exactly 1.7 seconds
		Thread splash_screen = new Thread(){
			@Override
			public void run(){
				try{  sleep(1700); 
					   setProgressBarVisibility(true);  }
				catch(Exception e) { 
					e.printStackTrace(); }
				
				finally {	
					ParseUser currentUser = ParseUser.getCurrentUser();
					if (currentUser == null) {
						startActivity (new Intent (getApplicationContext(),LoginActivity.class));
						finish(); }
					
					else {
						startActivity (new Intent (getApplicationContext(),MainActivity.class));
						finish(); } }	}   };
			splash_screen.start();
	}	
}