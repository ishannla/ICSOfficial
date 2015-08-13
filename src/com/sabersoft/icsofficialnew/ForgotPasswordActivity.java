
package com.sabersoft.icsofficialnew;



import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class ForgotPasswordActivity extends Activity {

	protected EditText mEmailText; 
	protected Button mSubmitButton; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_forgot_password);
		
		ActionBar actionbar = getActionBar();
		actionbar.hide();
		
		//Assign each element to its individual ID 
		mEmailText = (EditText)findViewById(R.id.emailField2);
		mSubmitButton = (Button)findViewById(R.id.submitButton);
		mSubmitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String email = mEmailText.getText().toString();
				email.trim();
				
				//Check whether the email entered is valid or not 
				if(email.isEmpty()) {
					AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPasswordActivity.this);
					builder.setMessage(R.string.forgot_password_label)
						.setTitle(R.string.sign_up_error_title)
						.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = builder.create();
					dialog.show();
				}
				
				//Sends an email to individual's account if the email entered was valid
				else {
					setProgressBarIndeterminateVisibility(true);
					ParseUser.requestPasswordResetInBackground(email,
                            new RequestPasswordResetCallback() {

						@Override
						public void done(ParseException e) {
							// TODO Auto-generated method stub
							 setProgressBarIndeterminateVisibility(false);
							 if (e == null) {
								     AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPasswordActivity.this);
									builder.setMessage("An email was sent. Please check your email within the next few minutes for more instructions")
									.setTitle("Success!")
									.setPositiveButton(android.R.string.ok, null);
									AlertDialog dialog = builder.create();
									dialog.show();  } 
							 else {
								 	AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPasswordActivity.this);
									builder.setMessage(R.string.forgot_password_label)
									.setTitle(R.string.sign_up_error_title)
									.setPositiveButton(android.R.string.ok, null);
									AlertDialog dialog = builder.create();
									dialog.show();
							    }  }  } );  }	}
		});

	}

}
