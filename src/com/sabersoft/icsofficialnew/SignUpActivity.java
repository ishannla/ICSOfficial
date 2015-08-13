package com.sabersoft.icsofficialnew;



import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends Activity {
	
	ParseUser newUser;
	protected EditText mFirstName;
	protected ProgressBar mProgressBar;
	protected EditText mLastName;
	protected EditText mPassword;
	protected EditText mEmail ;
	protected EditText mGrade;
	protected Button mSignUpButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_sign_up);
		
		ActionBar actionbar = getActionBar();
		actionbar.hide();
		
		//Assign each element to its individual ID
		mFirstName = (EditText)findViewById(R.id.firstname);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar3);
		mLastName = (EditText)findViewById(R.id.lastname);
		mPassword = (EditText)findViewById(R.id.passwordField1);
		mEmail = (EditText)findViewById(R.id.emailField1);
		mGrade = (EditText)findViewById(R.id.grade);
		mSignUpButton = (Button)findViewById(R.id.signUpButton);
		
		mSignUpButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mProgressBar.setVisibility(View.VISIBLE);
				String first = mFirstName.getText().toString();
				String last = mLastName.getText().toString();
				first = first.trim();
				last = last.trim();
				
				String password = mPassword.getText().toString();
				String email = mEmail.getText().toString();
				String grade = mGrade.getText().toString();
				
				password = password.trim();
				email = email.trim();
				grade = grade.trim();
				
				//Checks if any of the fields are empty/invalid
				if (first.isEmpty() || last.isEmpty() || grade.isEmpty() || password.isEmpty() || email.isEmpty()) {
					mProgressBar.setVisibility(View.INVISIBLE);
					AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
					builder.setMessage(R.string.sign_up_error)
						.setTitle(R.string.sign_up_error_title)
						.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show(); }
				else {
					setProgressBarIndeterminateVisibility(true);
					String firstLower = first.toLowerCase();
					String lastLower = last.toLowerCase();
					String username = firstLower + "." + lastLower;
					
					//Attempts to sign up a new user
					newUser = new ParseUser();
					newUser.setUsername(username);
					newUser.setPassword(password);
					newUser.setEmail(email);
					newUser.put("grade", grade);
					newUser.put("firstName", first);
					newUser.put("lastName", last);
					newUser.put("e1", 0);
					newUser.put("e2", 0);
					newUser.put("e3", 0);
					newUser.put("e4", 0);
					newUser.put("e5", 0);
					
					//Creates a dialog box that lists the username and password
					AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
					builder.setMessage("Your User Name is \"" + username + "\". Your Password is \"" + password + "\". Remember to use both credentials in order to log into the ICS Official App! ");
						builder.setTitle("Congratulations " + first + " " + last + "!")
						.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								newUser.signUpInBackground(new SignUpCallback() {
									
									@Override
									public void done(ParseException e) {
										// TODO Auto-generated method stub
										mProgressBar.setVisibility(View.INVISIBLE);
										setProgressBarIndeterminateVisibility(false);

										if (e == null){
											Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
											newUser.logOut();
											intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
											intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
											startActivity(intent); }
										else {
											AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
											builder.setMessage(R.string.sign_up_error_email)
												.setTitle(R.string.sign_up_error_title)
												.setPositiveButton(android.R.string.ok, null);
											AlertDialog dialog = builder.create();
											dialog.show(); } } }); } });
					
					AlertDialog dialog = builder.create();
					dialog.show();
				} } }); }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

	
	
}
