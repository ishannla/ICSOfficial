package com.sabersoft.icsofficialnew;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class StudentResources extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_resources); 
		
	//Assign each element to its individual ID 
	ImageButton facebookImage = (ImageButton)findViewById(R.id.imageButton1);	
	ImageButton extraImage = (ImageButton)findViewById(R.id.imageButton2);	
	ImageButton tutorImage = (ImageButton)findViewById(R.id.imageButton4);	
	ImageButton lwsdImage = (ImageButton)findViewById(R.id.imageButton3);	
	
	//Create intents to navigate between activities
	final Intent intentFacebook = new Intent().setClass(this, FacebookWebpage.class);
	final Intent intentExtra = new Intent().setClass(this, Extracurriculars.class);
	final Intent intentSSC = new Intent().setClass(this, SSCWebpage.class);
	final Intent intentLWSD = new Intent().setClass(this, LWSDWebpage.class);
	
	//Set an OnClickListener to start each intent 
	facebookImage.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			//showNotification();
			startActivity(intentFacebook); } });
	
	extraImage.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(intentExtra);	} });
	
	tutorImage.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(intentSSC); } });
	
	lwsdImage.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(intentLWSD); } });
	
	}

}
