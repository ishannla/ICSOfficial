package com.sabersoft.icsofficialnew;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;



public class ForumFragment extends ListFragment{
	
		public static final String TAG = MainActivity.class.getSimpleName();
		
		protected ProgressBar mProgressBar;
		protected Button mButton;
		protected Button mAddButton;
		protected ImageView mIcon; 
		protected RadioButton gradeRadio;
		protected RadioButton schoolRadio;
		static boolean schoolChecked = true;
		static boolean gradeChecked = false;	
		
		//Assign variables to each type of Forum
		public static final String KEY_TITLE = "title";
		public static final String KEY_MESSAGE = "message";
		public static final String SCHOOL_FORUM = "schoolForum";
		public static final String JUNIOR_FORUM = "juniorForum";
		public static final String NINE_FORUM = "nineForum";
		public static final String TEN_FORUM = "tenForum";
		public static final String ELEVEN_FORUM = "elevenForum";
		public static final String TWELVE_FORUM = "twelveForum";
		public static final String POSTS = "Post1";
		
		public static String finalVariable = "";
		public static String first = "";
		public static String titleString;
		public static String messageString;
		
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.forum, container,false);
			
			//Assigns each element to its individual ID 
			gradeRadio = (RadioButton)rootView.findViewById(R.id.radioGrade);
			schoolRadio = (RadioButton)rootView.findViewById(R.id.radioSchool);
			schoolRadio.setChecked(true);
			mProgressBar = (ProgressBar) rootView.findViewById(R.id.progressBar1);
			mButton = (Button) rootView.findViewById(R.id.refreshButton);
			mAddButton = (Button) rootView.findViewById(R.id.addButton1);
		
		return rootView;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		//Gets the current Parse User's Information
		final ParseUser currentUser = ParseUser.getCurrentUser();
	  
		//Get Grade Posts when RadioButton selected
		gradeRadio.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getLatestPosts();
			}});
		
		//Get School Posts when RadioButton selected
		schoolRadio.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getLatestPosts();
			}});
		
		mAddButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String grade = currentUser.getString("grade");
				int gradeNumber = Integer.parseInt(grade);
				String firstName = currentUser.getString("firstName");
				firstName = firstName.toUpperCase();
				first = firstName;
				String variable = null;
				
				//Checks which RadioButton has been currently selected
				if (ForumFragment.schoolChecked)
					variable = SCHOOL_FORUM;
				
				if (ForumFragment.gradeChecked) {
					if (gradeNumber <= 8)
						variable = JUNIOR_FORUM;
					
					if (gradeNumber == 9)
						variable = NINE_FORUM;
					
					if (gradeNumber == 10)
						variable = TEN_FORUM;
					
					if (gradeNumber == 11)
						variable = ELEVEN_FORUM;
					
					if (gradeNumber >= 12)
						variable = TWELVE_FORUM;;
				}
				
				 finalVariable = variable;

				 //Creates an input AlertDialog for content
			    AlertDialog.Builder alert1 = new AlertDialog.Builder(getActivity());
			    alert1.setTitle("New Forum Post");
				  alert1.setMessage("Please enter the CONTENT.");
		        
		        final EditText messageInput= new EditText(getActivity());
		        messageInput.setPadding(90, 100, 90, 100);
		        alert1.setView(messageInput);
				alert1.setPositiveButton("CONFIRM",
				        new DialogInterface.OnClickListener() {
				           @Override
						public void onClick(DialogInterface dialog, int which) {
				        	   messageString = messageInput.getText().toString();
				     
				        		if (!messageInput.equals(null)) {
				        			
				        			ParseObject actualVariable = new ParseObject(finalVariable);
				    				actualVariable.put(KEY_TITLE, titleString + " (" + first + ")");
				    				actualVariable.put(KEY_MESSAGE, messageString);
				    				actualVariable.saveInBackground();  } } } );

				    alert1.setNegativeButton("CANCEL",
				        new DialogInterface.OnClickListener() {
				            @Override
							public void onClick(DialogInterface dialog, int which) {
				                dialog.cancel();  }  }); alert1.show();
				                
				                
				 //Creates an input AlertDialog for title
				AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
				  alert.setTitle("New Forum Post");
				  alert.setMessage("Please enter the TITLE of your post."
				  		+ "                                                         ");
		        
		        final EditText titleInput= new EditText(getActivity());
		        titleInput.setPadding(90, 100, 90, 100);
		        alert.setView(titleInput);

				  alert.setPositiveButton("NEXT",
				        new DialogInterface.OnClickListener() {
				           @Override
						public void onClick(DialogInterface dialog, int which) {
				              titleString = titleInput.getText().toString();
				    }  }  );

				    alert.show(); } });
		
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getLatestPosts();	
			}
		});
		
		getLatestPosts();	
		
	}
	
	 //Method that refreshes the current feed
	protected void getLatestPosts() {
		
		mProgressBar.setVisibility(View.VISIBLE);
		ParseUser currentUser = ParseUser.getCurrentUser();
		String grade = currentUser.getString("grade");
		int gradeNumber = Integer.parseInt(grade);
		
		String forum = null;
		
		if (schoolRadio.isChecked()) {
			schoolChecked = true;
			gradeChecked = false;
			forum = "schoolForum";
		}
			
		else if (gradeRadio.isChecked()) {
			schoolChecked = false;
			gradeChecked = true;
			
			if (gradeNumber <= 8)
				forum = "juniorForum";
			
			if (gradeNumber == 9)
				forum = "nineForum";
			
			if (gradeNumber == 10)
				forum = "tenForum";
			
			if (gradeNumber == 11)
				forum = "elevenForum";
			
			if (gradeNumber == 12)
				forum = "twelveForum";
		}
			

		//Use ParseQuery to get latest posts
		ParseQuery query = new ParseQuery(forum);
		query.orderByDescending("createdAt");
		query.setLimit(100);

		query.findInBackground(new FindCallback<ParseObject>() {
			@Override
			public void done(List<ParseObject> results, ParseException e) {
				mProgressBar.setVisibility(View.INVISIBLE);

				if (e == null) {
					ArrayList<HashMap<String, String>> articles = new ArrayList<HashMap<String, String>>();
					for (ParseObject result : results) {
						HashMap<String, String> article = new HashMap<String, String>();
						
						article.put(KEY_MESSAGE,
								result.getString(KEY_MESSAGE));
						article.put(KEY_TITLE,
								result.getString(KEY_TITLE));
						articles.add(article);
					} 
					
					SimpleAdapter adapter = new SimpleAdapter(
							getActivity(), articles,
							android.R.layout.simple_list_item_2, new String[] {
									KEY_TITLE,
									KEY_MESSAGE }, new int[] {
									android.R.id.text1, android.R.id.text2 });
					setListAdapter(adapter);
					
				} else {
					Log.e(TAG, "Exception caught!", e);
				}
			}
		}); 
			
		}
};


