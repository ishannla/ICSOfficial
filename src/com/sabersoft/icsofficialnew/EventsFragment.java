
package com.sabersoft.icsofficialnew;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.EventsEntity;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;


public class EventsFragment extends Fragment implements OnItemSelectedListener{
	
	//Define initial set of variables
	Spinner calendarOptions;
	TextView todaysDate;
	 private String[] state = { "All Events", "ASB Events", "FBLA Events", "School Events",
	   "Other Events" , "No School"};
	
	 //Controls which event is selected - used for parameter purposes
	 int selection;
	 
	 //Get the current Parse User
	ParseUser currentUser = ParseUser.getCurrentUser();
	 
	 //Define each event TextView 
	 protected static TextView event1;
	 protected static TextView event2;
	 protected static TextView event3;
	 protected static TextView event4;
	 protected static TextView event5;
	 protected TextView event6;
	 protected TextView event7;
	 protected TextView event8;
	 protected TextView event9;
	 protected TextView event10;
	 protected TextView event11;
	 protected TextView event12;
	 protected TextView event13;
	 protected TextView event14;
	 protected TextView event15;
	 protected TextView event16;
	 protected TextView event17;
	 protected TextView event18;
	 protected TextView event19;
	 protected TextView event20;
	 protected TextView september;
	 protected TextView october;
	 protected TextView november;
	 protected TextView december;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.events, container, false);
		
		//Display the current date at the top of the event fragment
		String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
		mydate = mydate.substring(0,12);
	 	final ParseObject events = new ParseObject("events");
	 
		  //Assign each TextView to its individual ID 
		  event1 = (TextView) rootView.findViewById(R.id.event1);
		  event2 = (TextView) rootView.findViewById(R.id.event2);
		  event3 = (TextView) rootView.findViewById(R.id.event3);
		  event4 = (TextView) rootView.findViewById(R.id.event4);
		  event5 = (TextView) rootView.findViewById(R.id.event5);
		  event6 = (TextView) rootView.findViewById(R.id.event6);
		  event7 = (TextView) rootView.findViewById(R.id.event7);
		  event8 = (TextView) rootView.findViewById(R.id.event8);
		  event9 = (TextView) rootView.findViewById(R.id.event9);
		  event10 = (TextView) rootView.findViewById(R.id.event10);
		  event11 = (TextView) rootView.findViewById(R.id.event11);
		  event12 = (TextView) rootView.findViewById(R.id.event12);
		  event13 = (TextView) rootView.findViewById(R.id.event13);
		  event14 = (TextView) rootView.findViewById(R.id.event14);
		  event15 = (TextView) rootView.findViewById(R.id.event15);
		  event16 = (TextView) rootView.findViewById(R.id.event16);
		  event17 = (TextView) rootView.findViewById(R.id.event17);
		  event18 = (TextView) rootView.findViewById(R.id.event18);
		  event19 = (TextView) rootView.findViewById(R.id.event19);
		  event20 = (TextView) rootView.findViewById(R.id.event20);
		  september = (TextView) rootView.findViewById(R.id.textViewMarch);
		  october = (TextView) rootView.findViewById(R.id.textViewApril);
		  november = (TextView) rootView.findViewById(R.id.textViewMay);
		  december = (TextView) rootView.findViewById(R.id.textViewJune);
	
		  final Context context = getActivity();
		  final CharSequence[] items = {"Attending "," Not Attending "};
		  final Intent intentFacebook = new Intent().setClass(context, PostFacebook.class);
		  
		  //Create the first dialog box for events that also have RSVP capability
		  final AlertDialog.Builder options1 = new AlertDialog.Builder(context);
		  final CharSequence[] choices1 = {"RSVP to Event","View Event Description", "Add to Personal Calendar", "Invite Friends on Facebook"};
		  options1.setTitle("What would you like to do?");
		  options1.setItems(choices1, new DialogInterface.OnClickListener() {
					   
			  			@Override
			  			//Initiates a different method based on which button is clicked
					    public void onClick(DialogInterface dialog, int which) {
					      
			  				if (which == 0) {
			  					displayRSVP(selection, currentUser, context, items);
			  					selection = 0;
			  				} else if (which == 1)  {
					    	   		displayInfo(selection, context);
					    	   		selection = 0;
					       }  else if (which == 2) {
					        		addToCalendar(selection, context);
					        		selection = 0;
					        } else if (which == 3) 	{ 
					        		Toast.makeText(context, "Invite your friends by posting on your wall!", Toast.LENGTH_LONG).show(); 
					        		startActivity(intentFacebook); 
					        		selection = 0;
					        } } } );
		  
		  //Create the second dialog box for events that don't have RSVP capability
		  final AlertDialog.Builder options2 = new AlertDialog.Builder(context);
		  final CharSequence[] choices2 = {"View Event Description", "Add to Personal Calendar", "Invite Friends on Facebook"};
		  options2.setTitle("What would you like to do?");
		  options2.setItems(choices2, new DialogInterface.OnClickListener() {
					  
			  			@Override
			  		    //Initiates a different method based on which button is clicked
					    public void onClick(DialogInterface dialog, int which) {
					     
			  				if (which == 0) {
			  					displayInfo(selection, context);
			  					selection = 0;
			  				} else  if (which == 1) {
					         	addToCalendar(selection, context);
					         	selection = 0;
					        } else if (which == 2) { 
					        		Toast.makeText(context, "Invite your friends by posting on your wall!", Toast.LENGTH_LONG).show(); 
					         	startActivity(intentFacebook); 
					         	selection = 0;
					        } } } );
		  
		  
		  //Update the color of first 5 events depending on whether user attends or not 
		  int e1 = currentUser.getInt("e1");  
		  	updateColor(event1, e1, currentUser);
		  int e2 = currentUser.getInt("e2");  
		  	updateColor(event2, e2, currentUser);
		  int e3 = currentUser.getInt("e3");  
		  	updateColor(event3, e3, currentUser);
		  int e4 = currentUser.getInt("e4");  
		  	updateColor(event4, e4, currentUser);
		  int e5 = currentUser.getInt("e5");  
		  	updateColor(event5, e5, currentUser);
		  
		  //Set an OnClickListener for each event to display dialog box
		  event1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				selection = 1;
				options1.show();
			} } ) ;
		  
		  event2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 2;
					options1.show();
			} } ) ;
		  
		  event3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 3;
					options1.show();
			} } ) ;
		  
		 
		  event4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 4;
					options1.show();
			} } ) ;
		  
		  
		  event5.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 5;
					options1.show();
			} } ) ;
		  
		  
		  event6.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 6;
					options2.show();
		   } } ) ;	
		  
		  event7.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 7;
					options2.show();
		   } } ) ;
		  
		  event8.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 8;
					options2.show();
			} } ) ;
		  
		  event9.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 9;
					options2.show();
			} } ) ;
		  
		  event10.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 10;
					options2.show();
			} } ) ;
		  
		  event11.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 11;
					options2.show();
			} } ) ;
		  
		  event12.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 12;
					options2.show();
			} } ) ;
		  
		  event13.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 13;
					options2.show();
			} } ) ;
		  
		  
		  event14.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 14;
					options2.show();
			} } ) ;
		  
		  event16.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 16;
					options2.show();
			} } ) ;
		  
		  event17.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 17;
					options2.show();
			} } ) ;
		  
		  event18.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 18;
					options2.show();
			} } ) ;
		  
		  event19.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 19;
					options2.show();
			} } ) ;
		  
		  event20.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selection = 20;
					options2.show();
			} } ) ;
		  
		  //Display the current date
		  todaysDate = (TextView) rootView.findViewById(R.id.calendarDate);
		  calendarOptions = (Spinner) rootView.findViewById(R.id.calendarOptions);
		  
		  ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, state);
		  		adapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		  calendarOptions.setAdapter(adapter_state);
		  calendarOptions.setOnItemSelectedListener(this);
		  todaysDate.setText("  TODAY'S DATE - " + mydate);
		  
		return rootView;
	}
	
	//Method that allows for RSVP for the first five events
	public static void displayRSVP(int number, final ParseUser currentUser, final Context context, CharSequence[] items) {
		
		//Creates a specific AlertDialog box
		final AlertDialog.Builder builder = new AlertDialog.Builder(context);
		
		if (number == 1) {
			builder.setTitle("Mud Cup Week RSVP");
			builder.setPositiveButton("DISMISS",null);
			builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
			    
				@Override
			    public void onClick(DialogInterface dialog, int which) {
			       
					if (which == 0) {
			        		currentUser.put("e1", 1);
			        		currentUser.saveInBackground();
			        		int e1 = currentUser.getInt("e1");  
			        		updateColor(event1, e1, currentUser); 
			        		Toast.makeText(context, "Looking forward to seeing you there!", Toast.LENGTH_SHORT).show();  
			        	} else if (which == 1) {
			        		currentUser.put("e1", 2);
			        		currentUser.saveInBackground();
			        		int e1 = currentUser.getInt("e1");  
			        		updateColor(event1, e1, currentUser);
			        		Toast.makeText(context, "Hopefully we see you next time.", Toast.LENGTH_SHORT).show();  
			        	} }  } ); 
			
			builder.show();	
			
		}
		
		if (number == 2) {
			builder.setTitle("Book Drive RSVP");
			builder.setPositiveButton("DISMISS",null);
			builder.setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {
			   
				@Override
			    public void onClick(DialogInterface dialog, int which) {
			       
					if (which == 0) {
			        		currentUser.put("e2", 1);
			        		currentUser.saveInBackground();
			        		int e2 = currentUser.getInt("e2");  
			        		updateColor(event2, e2, currentUser); 
			        		Toast.makeText(context, "Looking forward to seeing you there!", Toast.LENGTH_SHORT).show(); 
			        	} else if (which == 1) {
			        		currentUser.put("e2", 2);
			        		currentUser.saveInBackground();
			        		int e2 = currentUser.getInt("e2");  
			        		updateColor(event2, e2, currentUser);
			        		Toast.makeText(context, "Hopefully we see you next time.", Toast.LENGTH_SHORT).show();  
			        	} } } ); 
			
			builder.show();	
			
		}
		
		if (number == 3) {
			builder.setTitle("Art Walk RSVP");
			builder.setPositiveButton("DISMISS",null);
			builder.setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {
			    
				@Override
			    public void onClick(DialogInterface dialog, int which) {
				
					if (which == 0) {
			        		currentUser.put("e3", 1);
			        		currentUser.saveInBackground();
			        		int e3 = currentUser.getInt("e3");  
			        		updateColor(event3, e3, currentUser); 
			        		Toast.makeText(context, "Looking forward to seeing you there!", Toast.LENGTH_SHORT).show();  	
			        	} else if (which == 1) {
			        		currentUser.put("e3", 2);
			        		currentUser.saveInBackground();
			        		int e3 = currentUser.getInt("e3");  
			        		updateColor(event3, e3, currentUser);
			        		Toast.makeText(context, "Hopefully we see you next time.", Toast.LENGTH_SHORT).show();  
			        	} }  } ) ; 
			
			builder.show();	
			
		}
		
		if (number == 4) {
			builder.setTitle("ASB Assembly RSVP");
			builder.setPositiveButton("DISMISS",null);
			builder.setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {
			    
				@Override
			    public void onClick(DialogInterface dialog, int which) {
			      
					if (which == 0) {
			        		currentUser.put("e4", 1);
			        		currentUser.saveInBackground();
			        		int e4 = currentUser.getInt("e4");  
			        		updateColor(event4, e4, currentUser); 
			        		Toast.makeText(context, "Looking forward to seeing you there!", Toast.LENGTH_SHORT).show();  
			        	} else if (which == 1) {
			        		currentUser.put("e4", 2);
			        		currentUser.saveInBackground();
			        		int e4 = currentUser.getInt("e4");  
			        		updateColor(event4, e4, currentUser);
			        		Toast.makeText(context, "Hopefully we see you next time.", Toast.LENGTH_SHORT).show(); 
			        	} } } ); 
			
			builder.show();	
		}
		
		if (number == 5) {
			
			builder.setTitle("Movie Night RSVP");
			builder.setPositiveButton("DISMISS",null);
			
			builder.setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {
			    
				@Override
			    public void onClick(DialogInterface dialog, int which) {
			        if (which == 0) {
			        		currentUser.put("e5", 1);
			        		currentUser.saveInBackground();
			        		int e5 = currentUser.getInt("e5");  
			        		updateColor(event5, e5, currentUser); 
			        		Toast.makeText(context, "Looking forward to seeing you there!", Toast.LENGTH_SHORT).show();  	
			        	} else if (which == 1) {
			        		currentUser.put("e5", 2);
			        		currentUser.saveInBackground();
			        		int e5 = currentUser.getInt("e5");  
			        		updateColor(event5, e5, currentUser);
			        		Toast.makeText(context, "Hopefully we see you next time.", Toast.LENGTH_SHORT).show();  
			        	}} }); 
			
			builder.show();	
		}
	}
	
	//Method that displays the event information when requested
	public static void displayInfo (int number, Context context) {
		
		//Creates a specific AlertDialog box
		final AlertDialog.Builder builder = new AlertDialog.Builder(context);
		
		if (number == 1) {
			AlertDialog alert;
			builder.setTitle("September 7th - 11th");
			builder.setMessage("SNHS will be selling tasty mudcups in order to raise funds to buy more equipment for their club. Try some!");
			builder.setPositiveButton("DISMISS",null);
			 alert = builder.create();
			  alert.show(); 
		}	
		
		else if (number == 2) {
			AlertDialog alert;
			builder.setTitle("September 12th, 9:00 AM");
			builder.setMessage("Please donate books to the Book Drive. These books will be given to those in need. Please volunteer!");
			builder.setPositiveButton("DISMISS",null);
			 alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 3) {
			AlertDialog alert;
			builder.setTitle("September 19th, 7:30 PM");
			builder.setMessage("NAHS will be hosting the annual art walk. Join for a night of fun! You will be viewing the work of incredibly talented artists.");
			builder.setPositiveButton("DISMISS",null);
			 alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 4) {
			AlertDialog alert;
			builder.setTitle("September 23rd, 11:00 AM");
			builder.setMessage("The first assembly of the year. Exciting, right? ASB will be going over important changes that they will be implementing.");
			builder.setPositiveButton("DISMISS",null);
			 alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 5) {
			AlertDialog alert = builder.create();
			builder.setTitle("September 25th, 8:00 PM");
			builder.setMessage("In order to raise money for the March of Dimes charity, FBLA will be hosting an annual charity movie night in the Lyceum.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 6) {
			AlertDialog alert = builder.create();
			builder.setTitle("October 9th");
			builder.setMessage("There will be no school because of teacher conferences. Don't forget to do your homework!");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 7) {
			AlertDialog alert = builder.create();
			builder.setTitle("October 16th, 9:00 AM");
			builder.setMessage("ICS FBLA Members, you have the opportunity to experiment with many competitive events at FLC. Remember to sign up!");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 8) {
			AlertDialog alert = builder.create();
			builder.setTitle("October 17th, 7:00 PM");
			builder.setMessage("Want to see your friends on the red carpet? At the Key Club talent show, you can cheer on your friends and watch them display their talents.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 9) {
			AlertDialog alert = builder.create();
			builder.setTitle("October 19th");
			builder.setMessage("The senior soccer team will take on the teachers in this annual soccer game, held during lunch! Tryouts are the week before.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 10) {
			AlertDialog alert = builder.create();
			builder.setTitle("October 24th, 8:00 PM");
			builder.setMessage("The Drama act “Gladiator” will be held in the ICS Lyceum on Friday evening! Concessions will be available for purchase.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 11) {
			AlertDialog alert = builder.create();
			builder.setTitle("November 2nd");
			builder.setMessage("Want your grade to win a pizza party? The grade that donates the most food will win a pizza party! Food will be collected in front of the main office and will be donated to the Hopelink food bank.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 12) {
			AlertDialog alert = builder.create();
			builder.setTitle("November 4th");
			builder.setMessage("Get out your state testing study books, calculators, and #2 pencils! State tests will be given sooner than you think—don’t procrastinate!");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 13) {
			AlertDialog alert = builder.create();
			builder.setTitle("November 9th - 13th");
			builder.setMessage("Get ready for trips to New York, Costa Rica, and Spain! The focus week adventure that you selected will take place during this week. If you are traveling, your plane may leave before Focus Week officially begins; please contact your Focus Week teacher for more information.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 14) {
			AlertDialog alert = builder.create();
			builder.setTitle("November 21st, 10:00 AM");
			builder.setMessage("The FBLA Walk-a-Thon will take place at Grasslawn Park. Sponsored by NHS, all money made from this event will be donated to the Task Force for Global Health.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 16) {
			AlertDialog alert = builder.create();
			builder.setTitle("December 1st - 4th");
			builder.setMessage("ICS Mock Trial is hosting a fundraiser! Do you want to send your friend a gift, or ask someone special to Winter Ball? Using a Teddygram is the perfect way to do it.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 17) {
			AlertDialog alert = builder.create();
			builder.setTitle("December 4th, 8:00 PM");
			builder.setMessage("I’m never going to give you up, never going to let you down, never going to desert you! Juniors and Seniors, this year’s Winter Ball theme is the Rick Roll, and will be held at Grass Lawn.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 18) {
			AlertDialog alert = builder.create();
			builder.setTitle("December 14th - 16th");
			builder.setMessage("The last tests of the school year will be upon us! Study hard, because you only have one opportunity to take your tests!");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 19) {
			AlertDialog alert = builder.create();
			builder.setTitle("December 17th, 3:00 PM");
			builder.setMessage("The annual FBLA party will be held on this day. We will be celebrating for all of the students that have decided to compete at regionals.");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}
		
		else if (number == 20) {
			AlertDialog alert = builder.create();
			builder.setTitle("December 18th");
			builder.setMessage("Last Day of First Semester. Enjoy your winter break and we hope that Santa gives you some nice Christmas presents!");
			builder.setPositiveButton("DISMISS",null);
			  alert = builder.create();
			  alert.show(); 
		}

		
	}
	
	//Method that adds an event to the user's personal calendar application
	public static void addToCalendar (int number, Context context) {
		Calendar cal = Calendar.getInstance();              
		Intent intent = new Intent(Intent.ACTION_EDIT);
		if (number == 1) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Mud Cup Week");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date1 = new GregorianCalendar(2015, 8, 7);
			Calendar date2 = new GregorianCalendar(2015, 8, 11);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date1.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date2.getTimeInMillis());
			context.startActivity(intent);
		}
		
		else if (number == 2) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Book Drive");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 8, 12);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis() + 9 * 60 * 60 * 1000);
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis() + 10 * 60 * 60 * 1000);
			context.startActivity(intent);
		}
		
		else if (number == 3) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "School Art Walk");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 8, 19);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis() + 19 * 60 * 60 * 1000 + 30 * 60 * 1000);
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis() + 22 * 60 * 60 * 1000);
			context.startActivity(intent);
		}
		
		else if (number == 4) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "ASB Elections");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 8, 23);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis() + 11 * 60 * 60 * 1000 + 0 * 60 * 1000);
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis() + 12 * 60 * 60 * 1000);
			context.startActivity(intent);
		}
		
		else if (number == 5) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Charity Movie Night");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 8, 25);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis() + 20 * 60 * 60 * 1000 + 0 * 60 * 1000);
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis() + 22 * 60 * 60 * 1000);
			context.startActivity(intent);
		}
		
		else if (number == 6) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Teacher Conferences");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 9, 9);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis());
			context.startActivity(intent);
		}
		
		else if (number == 7) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "FBLA Fall Conference");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 9, 16);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis());
			context.startActivity(intent);
		}
		
		else if (number == 8) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Key Club Talent Show");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 9, 17);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis() + 19 * 60 * 60 * 1000 + 0 * 60 * 1000);
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis() + 21 * 60 * 60 * 1000);
			context.startActivity(intent);
		}
		
		else if (number == 9) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Soccer Competition");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 9, 19);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis());
			context.startActivity(intent);
		}
		
		else if (number == 10) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Drama Play Production");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 9, 24);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis() + 20 * 60 * 60 * 1000 + 0 * 60 * 1000);
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis() + 22 * 60 * 60 * 1000);
			context.startActivity(intent);
		}
		
		else if (number == 11) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Food Drive");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date1 = new GregorianCalendar(2015, 10, 2);
			Calendar date2 = new GregorianCalendar(2015, 10, 6);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date1.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date2.getTimeInMillis());
			context.startActivity(intent);
		}
		
		else 	if (number == 12) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "State Testing");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date1 = new GregorianCalendar(2015, 10, 4);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date1.getTimeInMillis());
			context.startActivity(intent);
		}
		
		else if (number == 13) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "ICS Focus Week");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date1 = new GregorianCalendar(2015, 10, 9);
			Calendar date2 = new GregorianCalendar(2015, 10, 14);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date1.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date2.getTimeInMillis());
			context.startActivity(intent);
		}
		
		else if (number == 14) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "FBLA Walk-A-Thon");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 10, 21);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis() + 10 * 60 * 60 * 1000 + 0 * 60 * 1000);
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis() + 12 * 60 * 60 * 1000);
			context.startActivity(intent);
		}
		
		else if (number == 16) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "TeddyGrams Week");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date1 = new GregorianCalendar(2015, 11, 1);
			Calendar date2 = new GregorianCalendar(2015, 11, 4);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date1.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date2.getTimeInMillis());
			context.startActivity(intent);
		}
		
		else if (number == 17) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Winter Ball");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 11, 4);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis() + 20 * 60 * 60 * 1000 + 0 * 60 * 1000);
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis() + 22 * 60 * 60 * 1000);
			context.startActivity(intent);
		}
		
		else if (number == 18) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Semester Finals");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date1 = new GregorianCalendar(2015, 11, 14);
			Calendar date2 = new GregorianCalendar(2015, 11, 16);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date1.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date2.getTimeInMillis());
			context.startActivity(intent);
		}
		
		else if (number == 19) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "FBLA Farewell Part");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 11, 17);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis() + 15 * 60 * 60 * 1000 + 0 * 60 * 1000);
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis() + 17 * 60 * 60 * 1000);
			context.startActivity(intent);
		}
		
		else if (number == 20) {
			intent.setType("vnd.android.cursor.item/event");
			intent.putExtra(Events.TITLE, "Last Day of Semester");
			intent.putExtra(Events.EVENT_LOCATION, "International Community School");
			Calendar date = new GregorianCalendar(2015, 11, 18);
			intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
			intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, date.getTimeInMillis());
			intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, date.getTimeInMillis());
			context.startActivity(intent);
		}
		
	}
	
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		
		
		// "Sorting filter" modifies which events user wants to display at the moment
		if(position == 0) {
			
			event1.setVisibility(View.VISIBLE); 
			event2.setVisibility(View.VISIBLE);
			event3.setVisibility(View.VISIBLE);
			event4.setVisibility(View.VISIBLE); 
			event5.setVisibility(View.VISIBLE);
			event6.setVisibility(View.VISIBLE);
			event7.setVisibility(View.VISIBLE);
			event8.setVisibility(View.VISIBLE);
			event9.setVisibility(View.VISIBLE);
			event10.setVisibility(View.VISIBLE);
			event11.setVisibility(View.VISIBLE);
			event12.setVisibility(View.VISIBLE);
			event13.setVisibility(View.VISIBLE);
			event14.setVisibility(View.VISIBLE);
			event15.setVisibility(View.GONE);
			event16.setVisibility(View.VISIBLE);
			event17.setVisibility(View.VISIBLE);
			event18.setVisibility(View.VISIBLE);
			event19.setVisibility(View.VISIBLE);
			event20.setVisibility(View.VISIBLE);
			
			september.setVisibility(View.VISIBLE); 
			october.setVisibility(View.VISIBLE); 
			november.setVisibility(View.VISIBLE);
			december.setVisibility(View.VISIBLE); 
		
			
		}
		
		if (position == 1) {
			
			event1.setVisibility(View.GONE); 
			event2.setVisibility(View.GONE);
			event3.setVisibility(View.GONE);
			event4.setVisibility(View.VISIBLE); 
			event5.setVisibility(View.GONE);
			event6.setVisibility(View.GONE	);
			event7.setVisibility(View.GONE);
			event8.setVisibility(View.GONE);
			event9.setVisibility(View.VISIBLE);
			event10.setVisibility(View.GONE);
			event11.setVisibility(View.GONE);
			event12.setVisibility(View.GONE);
			event13.setVisibility(View.GONE);
			event14.setVisibility(View.GONE);
			event15.setVisibility(View.GONE);
			event16.setVisibility(View.GONE);
			event17.setVisibility(View.VISIBLE);
			event18.setVisibility(View.GONE);
			event19.setVisibility(View.GONE);
			event20.setVisibility(View.GONE);
	
			september.setVisibility(View.VISIBLE); 
			october.setVisibility(View.VISIBLE); 
			november.setVisibility(View.GONE);
			december.setVisibility(View.VISIBLE); 
			
			  
			
		}
		
		if (position == 2) {
			
			
			event1.setVisibility(View.GONE); 
			event2.setVisibility(View.GONE);
			event3.setVisibility(View.GONE);
			event4.setVisibility(View.GONE); 
			event5.setVisibility(View.VISIBLE);
			event6.setVisibility(View.GONE);
			event7.setVisibility(View.VISIBLE);
			event8.setVisibility(View.GONE);
			event9.setVisibility(View.GONE);
			event10.setVisibility(View.GONE);
			event11.setVisibility(View.GONE);
			event12.setVisibility(View.GONE);
			event13.setVisibility(View.GONE);
			event14.setVisibility(View.VISIBLE);
			event15.setVisibility(View.GONE);
			event16.setVisibility(View.GONE);
			event17.setVisibility(View.GONE);
			event18.setVisibility(View.GONE);
			event19.setVisibility(View.VISIBLE);
			event20.setVisibility(View.GONE);
			
			september.setVisibility(View.VISIBLE); 
			october.setVisibility(View.VISIBLE); 
			november.setVisibility(View.VISIBLE);
			december.setVisibility(View.VISIBLE); 
		
		}
		
		if (position == 3) {
			
			
			event1.setVisibility(View.GONE); 
			event2.setVisibility(View.GONE);
			event3.setVisibility(View.GONE);
			event4.setVisibility(View.GONE); 
			event5.setVisibility(View.GONE);
			event6.setVisibility(View.GONE);
			event7.setVisibility(View.GONE);
			event8.setVisibility(View.GONE);
			event9.setVisibility(View.GONE);
			event10.setVisibility(View.GONE);
			event11.setVisibility(View.GONE);
			event12.setVisibility(View.VISIBLE);
			event13.setVisibility(View.VISIBLE);
			event14.setVisibility(View.GONE);
			event15.setVisibility(View.GONE);
			event16.setVisibility(View.GONE);
			event17.setVisibility(View.GONE);
			event18.setVisibility(View.VISIBLE);
			event19.setVisibility(View.GONE);
			event20.setVisibility(View.GONE);
		
			september.setVisibility(View.GONE); 
			october.setVisibility(View.GONE); 
			november.setVisibility(View.VISIBLE);
			december.setVisibility(View.VISIBLE); 
			
		}
		
		if (position == 4) {
			
			event1.setVisibility(View.VISIBLE); 
			event2.setVisibility(View.VISIBLE);
			event3.setVisibility(View.VISIBLE);
			event4.setVisibility(View.GONE); 
			event5.setVisibility(View.GONE);
			event6.setVisibility(View.GONE);
			event7.setVisibility(View.GONE);
			event8.setVisibility(View.VISIBLE);
			event9.setVisibility(View.GONE);
			event10.setVisibility(View.VISIBLE);
			event11.setVisibility(View.VISIBLE);
			event12.setVisibility(View.GONE);
			event13.setVisibility(View.GONE);
			event14.setVisibility(View.GONE);
			event15.setVisibility(View.GONE);
			event16.setVisibility(View.VISIBLE);
			event17.setVisibility(View.GONE);
			event18.setVisibility(View.GONE);
			event19.setVisibility(View.GONE);
			event20.setVisibility(View.GONE);
		
			september.setVisibility(View.VISIBLE); 
			october.setVisibility(View.VISIBLE); 
			november.setVisibility(View.VISIBLE);
			december.setVisibility(View.VISIBLE); 
		
		}
		
		if (position == 5) {
			/* Toast.makeText(parent.getContext(), "Holidays Selected ",
					Toast.LENGTH_SHORT).show(); */
			event1.setVisibility(View.GONE); 
			event2.setVisibility(View.GONE);
			event3.setVisibility(View.GONE);
			event4.setVisibility(View.GONE); 
			event5.setVisibility(View.GONE);
			event6.setVisibility(View.VISIBLE);
			event7.setVisibility(View.GONE);
			event8.setVisibility(View.GONE);
			event9.setVisibility(View.GONE);
			event10.setVisibility(View.GONE);
			event11.setVisibility(View.GONE);
			event12.setVisibility(View.GONE);
			event13.setVisibility(View.GONE);
			event14.setVisibility(View.GONE);
			event15.setVisibility(View.GONE);
			event16.setVisibility(View.GONE);
			event17.setVisibility(View.GONE);
			event18.setVisibility(View.GONE);
			event19.setVisibility(View.GONE);
			event20.setVisibility(View.VISIBLE);

			september.setVisibility(View.GONE); 
			october.setVisibility(View.VISIBLE); 
			november.setVisibility(View.GONE);
			december.setVisibility(View.VISIBLE); 
		
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
	}
	
	//Repeated set color method
	public static void updateColor(TextView event, int e, ParseUser currentUser) {
		  if (e == 1)	
				 event.setTextColor(Color.parseColor("#6CDA6C"));
			if (e == 2)
				 event.setTextColor(Color.parseColor("#FCD116")); 
	}
}
