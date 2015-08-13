
package com.sabersoft.icsofficialnew;



import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class Extracurriculars extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.extracurriculars);
		
		//Assign each Button to its individual ID 
		Button ASB = (Button) findViewById(R.id.ASB);
		Button FBLA = (Button) findViewById(R.id.FBLA);
		Button Mock = (Button) findViewById(R.id.Mock);
		Button Key = (Button) findViewById(R.id.Key);
		Button MUN = (Button) findViewById(R.id.MUN);
		Button NHS = (Button) findViewById(R.id.NHS);
		Button Drama = (Button) findViewById(R.id.Drama);
		Button Environmental = (Button) findViewById(R.id.Environmental);
		
		final AlertDialog.Builder builder = new AlertDialog.Builder(this); 
		
		//Assign an OnClickListener to each Button that creates an AlertDialog
		ASB.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				AlertDialog alert = builder.create();
				builder.setTitle("ASB Leadership Club");
				builder.setMessage("Advisor: Mrs. Nelson                               Time: Monday, 2:05 - 3:05");
				builder.setPositiveButton("DISMISS",null);
				  alert = builder.create();
				  alert.show(); 
			}
		});
		
		FBLA.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = builder.create();
				builder.setTitle("FBLA Business Club");
				builder.setMessage("Advisor: Mrs. Henry                               Time: Wednesday, 12:30 - 1:35");
				builder.setPositiveButton("DISMISS",null);
				  alert = builder.create();
				  alert.show(); 
			}
		});
		
		Mock.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = builder.create();
				builder.setTitle("Mock Trial Law Club");
				builder.setMessage("Advisor: Mr. Over                               Time: Tuesday, 2:05 - 3:05");
				builder.setPositiveButton("DISMISS",null);
				  alert = builder.create();
				  alert.show(); 
			}
		});
		
		Key.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = builder.create();
				builder.setTitle("Key Club Volunteering Club");
				builder.setMessage("Advisor: Mr. Plank                               Time: Thursday, 11:30 - 12:00");
				builder.setPositiveButton("DISMISS",null);
				  alert = builder.create();
				  alert.show(); 
			}
		});
		
		MUN.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = builder.create();
				builder.setTitle("Model United Nations Club");
				builder.setMessage("Advisor: Mr. Bach                               Time: Thursday, 2:05 - 3:05");
				builder.setPositiveButton("DISMISS",null);
				  alert = builder.create();
				  alert.show(); 
			}
		});
		
		NHS.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = builder.create();
				builder.setTitle("National Honor Society Club");
				builder.setMessage("Advisor: Mrs. Sullivan                               Time: Friday, 11:30 - 12:00");
				builder.setPositiveButton("DISMISS",null);
				  alert = builder.create();
				  alert.show(); 
			}
		});
		
		Drama.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = builder.create();
				builder.setTitle("Drama Club");
				builder.setMessage("Advisor: Mrs. Garman                               Time: Fridays, 2:05 - 3:05");
				builder.setPositiveButton("DISMISS",null);
				  alert = builder.create();
				  alert.show(); 
			}
		});
		
		Environmental.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = builder.create();
				builder.setTitle("Environmental Club");
				builder.setMessage("Advisor: Ms. Vasiliauskas                               Time: Mondays, 2:05 - 3:05");
				builder.setPositiveButton("DISMISS",null);
				  alert = builder.create();
				  alert.show(); 
			}
		});
		

	}
}




