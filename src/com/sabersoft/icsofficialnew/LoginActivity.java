package com.sabersoft.icsofficialnew;


import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends Activity {

	protected TextView mSignUpTextView;
	protected TextView mForgotPassword; 
	protected ProgressBar mProgressBar;
	protected EditText mUserName;
	protected EditText mPassword;
	protected Button mLoginButton;
	protected EditText mCode; 
	public static int passcode; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_login);
		
		ActionBar actionbar = getActionBar();
				actionbar.hide();
		
		//Assign each element to its individual ID 
		mUserName = (EditText)findViewById(R.id.usernameField);
		mPassword = (EditText)findViewById(R.id.passwordField);
		mLoginButton = (Button)findViewById(R.id.loginButton);
		mCode = (EditText)findViewById(R.id.appCode); 
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);
		
		mLoginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String username = mUserName.getText().toString();
				String password = mPassword.getText().toString();
				String code = mCode.getText().toString();
				mProgressBar.setVisibility(View.VISIBLE);
				
				if (!code.isEmpty()) {
				passcode = Integer.parseInt(code); }
				username = username.trim();
				password = password.trim();
				code = code.trim();
				
				//Check whether the passcode is correct
				if (passcode != 842135)
					mProgressBar.setVisibility(View.INVISIBLE);
				
				//Display an Error Message if all fields are empty
				if (username.isEmpty() || password.isEmpty() || code.isEmpty()) {
					mProgressBar.setVisibility(View.INVISIBLE);
					AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
					builder.setMessage(R.string.login_error)
						.setTitle(R.string.sign_up_error_title)
						.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show(); }
				
				//Log in if passcode is correct
				else if (passcode == 842135) {
					
						setProgressBarIndeterminateVisibility(true);
						ParseUser.logInInBackground(username, password, new LogInCallback() {
						
						@Override
						public void done(ParseUser user, ParseException e) {
							mProgressBar.setVisibility(View.INVISIBLE);
							// TODO Auto-generated method stub
							setProgressBarIndeterminateVisibility(false);
							if (e == null){
								Intent intent = new Intent(LoginActivity.this, MainActivity.class);
								intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
								startActivity(intent); }
							else {
								AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
								builder.setMessage("Some of your credentials are invalid.")
									.setTitle(R.string.sign_up_error_title)
									.setPositiveButton(android.R.string.ok, null);
								AlertDialog dialog = builder.create();
								dialog.show();
							} } }); } 
				
				else {
					AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
					builder.setMessage("Your Passcode is incorrect. Read the documentation to obtain the correct passcode and access the application.")
						.setTitle(R.string.sign_up_error_title)
						.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show(); } } });
		

		// Navigate from LogIn Activity to SignUp Activity or Forgot Password Activity
		mSignUpTextView = (TextView)findViewById(R.id.signUpText);
		mForgotPassword = (TextView)findViewById(R.id.forgotPassword); 
		mForgotPassword.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
				startActivity(intent); } });
		
		mSignUpTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
			   startActivity(intent); } }); }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		//if (id == R.id.action_settings) {
		//	return true;
		//}
		return super.onOptionsItemSelected(item);
	}
}
