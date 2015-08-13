package com.sabersoft.icsofficialnew;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class TeacherList extends Activity{
	
	public static int teacher = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher);
		
		//Assign each element to its individual ID
		 final ImageView changer  = (ImageView)findViewById(R.id.imageChanger);
		 final Button email = (Button) findViewById(R.id.emailButton);
		 final Button bio = (Button) findViewById(R.id.bioButton);
		 final TextView large = (TextView) findViewById(R.id.textView1);
		 final TextView medium = (TextView) findViewById(R.id.textView2);
		 
		final Intent emailer = new Intent(Intent.ACTION_SEND);
		final AlertDialog.Builder builder = new AlertDialog.Builder(TeacherList.this);
		
		//Set an OnClickListener to email teacher
		email.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// Ask the user if they want to navigate the default phone email application
					        	   		emailer.setType("message/rfc822");
									emailer.putExtra(Intent.EXTRA_SUBJECT, "");
									emailer.putExtra(Intent.EXTRA_TEXT   , "");
									startActivity(Intent.createChooser(emailer, "Choose an email client from..."));    
				} });
		
		//OnClickListener to view teacher bio
		bio.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				builder.setTitle("Faculty Bio");
				builder.setCancelable(true);
				builder.setNegativeButton("Dismiss",new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}});
			
				AlertDialog alertDialog = builder.create();
				alertDialog.show();
		       
			} });
		 
		 
		//Assign a different email and bio to each teacher 
		 if (teacher == 0) {
		 changer.setImageResource(R.drawable.moncada);
		 large.setText("Dr. Gregory Moncada");
		 medium.setText("SCHOOL PRINCIPAL");
		emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"gmoncada@lwsd.org"});
		builder.setMessage("*Newly Hired as Principal of ICS*");
	 
		 }
		 
		 else if (teacher == 1) {
			 changer.setImageResource(R.drawable.peterson); 
				 large.setText("Harriet Peterson");
				 medium.setText("OFFICE ASSISTANT");
				emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"hpeterson@lwsd.org"});
				builder.setMessage("My role as ICS office manager grew out of years of experience with the Lake Washington School District. For five years I served as ELL teacher assistant and library secretary. This path led me to ICS. ");
			 }
		 
		 else if (teacher == 2) {
			 changer.setImageResource(R.drawable.austin); 
				 large.setText("Sue Austin");
				 medium.setText("OFFICE ASSISTANT");
				 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"SAustin@lwsd.org"});
				 builder.setMessage(" I was raised in the east San Francisco bay area. I met my husband while in college and followed Bob up to Seattle, his hometown. We have two children, Chris and Colleen who attended Lake Washington schools. ");
			 }
		 
		 else if (teacher == 3) {
			 changer.setImageResource(R.drawable.christiansen);
			 large.setText("Lis Christiansen");
			 medium.setText("SCHOOL COUNSELOR");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"lchristiansen@lwsd.org"});
			 builder.setMessage("I grew up in a tiny town in southern Texas, but I didn’t stay there long after high school. Naturally, my favorite teachers were humanities teachers.  Mr. Fleming was my 10th grade English teacher; he was a softy who loved to tell engaging stories.");
		 }
		 
		 else if (teacher == 4) {
			 changer.setImageResource(R.drawable.sharma);
			 large.setText("Dr. Madhu Sharma");
			 medium.setText("HEAD OF CHEMISTRY");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"masharma@lwsd.org"});
			 builder.setMessage(" I taught Chemistry for more than six years in some of the leading schools in India. In my last assignment before moving to Seattle, I was a high school Chemistry Teacher at Delhi Public School in New Delhi (R.K.Puram), one of the best schools in India. ");
		 }
		 
		 else if (teacher == 5) {
			 changer.setImageResource(R.drawable.mcfaul);
			 large.setText("Timothy McFaul");
			 medium.setText("HEAD OF BIOLOGY");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"tmcfaul@lwsd.org"});
			 builder.setMessage("I began my journey as a zygote in Montana. Six years later I decided upon a life-long career; marine biology. I cannot really say what inspired my love of the ocean coming from a landlocked state, but I was unwavering in my aspirations. ");
		 }
		 
		 else if (teacher == 6) {
			 changer.setImageResource(R.drawable.vasilia);
			 large.setText("Julia Vasiliauskas");
			 medium.setText("HEAD OF EARTH SCIENCE");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"jvasiliauskas@lwsd.org"});
			 builder.setMessage("I grew up in rural, upstate NY in the beautiful Finger Lakes. Since my childhood I have always loved everything to do with the outdoors and science, and followed that passion to the Northwest.");
		 }
		 
		 else if (teacher == 7) {
			 changer.setImageResource(R.drawable.sullivan);
			 large.setText("Nancy Sullivan");
			 medium.setText("HEAD OF CALCULUS");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"nasullivan@lwsd.org"});
			 builder.setMessage("While still in high school, the idea of becoming a math teacher was planted, as I enjoyed helping my friends with their math homework. I knew right away while student teaching that I picked the right career for me. ");
		 }
		 
		 else if (teacher == 8) {
			 changer.setImageResource(R.drawable.henry);
			 large.setText("Helen Henry");
			 medium.setText("HEAD OF ALGEBRA");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"hhenry@lwsd.org"});
			 builder.setMessage("When I first graduated from college, I worked for Hewlett Packard as a systems engineer. Upon moving to Seattle, I started work as an International Systems Engineer for Attachmate Corporation.");
		 }

		 else if (teacher == 9) {
			 changer.setImageResource(R.drawable.gibson);
			 large.setText("Greg Gibson");
			 medium.setText("HEAD OF PHYSICS");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ggibson@lwsd.org"});
			 builder.setMessage("When I was in high school, my dream was to teach mathematics and coach baseball.  My counselor suggested that since I was good at math and science, that I should go into engineering; he suggested that I would be good at it and there were many high paying jobs.");
		 }
		 
		 else if (teacher == 10) {
			 changer.setImageResource(R.drawable.lentz);
			 large.setText("Meredith Lentz");
			 medium.setText("PRE-ALGEBRA TEACHER");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mlentz@lwsd.org"});
			 builder.setMessage("I grew up in a small town in southern Oregon. Education was a huge part of my upbringing because my parents are both teachers. They set a good example and instilled in me a great respect for those who dedicate themselves to preparing future generations.");
		 }
		 
		 else if (teacher == 11) {
			 changer.setImageResource(R.drawable.packer);
			 large.setText("Andrya Packer");
			 medium.setText("HEAD OF HUMANITIES");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"apacker@lwsd.org "});
			 builder.setMessage("I was born and raised in a small town called Rigby in southeastern Idaho. I enjoyed camping with my large extended family, but spent the majority of my time reading and writing. I also enjoy gardening, hiking, travelling and theater.");
		 }
		 
		 else if (teacher == 12) {
			 changer.setImageResource(R.drawable.plank);
			 large.setText("Paul Plank");
			 medium.setText("HEAD OF HUMANITIES");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"pplank@lwsd.org"});
			 builder.setMessage(" first thought about teaching as a possible profession when I was a junior in high school, before that my mother swore that I would be a lawyer or an actor, and I still harbored thoughts of continuing my professional DJ career. ");
		 }
		 
		 else if (teacher == 13) {
			 changer.setImageResource(R.drawable.castaneda);
			 large.setText("Victoria Castaneda");
			 medium.setText("HEAD OF HUMANITIES");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"vcastaneda@lwsd.org"});
			 builder.setMessage("I was born and raised in the South Sound region where I built up immunity to the Tacoma Aroma. I determined my future career at the tender age of six; I adored my kindergarten teacher, Ms. McCarthy, and my first grade teacher, Ms. Alexander.");
		 }
		 
		 else if (teacher == 14) {
			 changer.setImageResource(R.drawable.garman);
			 large.setText("Brynne Garman");
			 medium.setText("HUMANITIES TEACHER");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"bgarman@lwsd.org"});
			 builder.setMessage("I was raised in Washington state by two unorthodox high school teachers who taught me to shun television and value an active mental and physical life. At age 10, I won an award for reading more library books than anyone else in Jefferson County! ");
		 }
		 
		 else if (teacher == 15) {
			 changer.setImageResource(R.drawable.bach);
			 large.setText("Mark Bach");
			 medium.setText("HEAD OF US HISTORY");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mbach@lwsd.org"});
			 builder.setMessage("Teaching has taken me all over the globe so it is fitting that I would return to an international school. I grew up in a Lutheran parsonage in Wisconsin, California, and Minnesota which was my own tour of the United States growing up. I enjoyed my own high school experience immensely as an athlete (football and tennis), dramatist, and student leader. ");
		 }
		 
		 else if (teacher == 16) {
			 changer.setImageResource(R.drawable.elliott);
			 large.setText("Mark Elliott");
			 medium.setText("HEAD OF WORLD HISTORY");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"melliott@lwsd.org"});
			 builder.setMessage("Former President of RezTech, Former Director of Television Services at BCC, School Director at Bailie School of Broadcast.");
		 }
		 
		  else if (teacher == 17) {
			 changer.setImageResource(R.drawable.over);
			 large.setText("Ted Over");
			 medium.setText("HEAD OF COMP. GOVERNMENT");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"eover@lwsd.org"});
			 builder.setMessage("My secondary school teachers continually inspired me to admire the just, the good and the true; they made me want to choose a profession where I could further these principles. ");
		 }
		 
		 else if (teacher == 18) {
			 changer.setImageResource(R.drawable.rayder);
			 large.setText("Mark Rayder");
			 medium.setText("HEAD OF ART");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mrayder@lwsd.org"});
			 builder.setMessage("*Current Art Teacher at ICS*");
		 }
		 
		 else if (teacher == 19) {
			 changer.setImageResource(R.drawable.nelson);
			 large.setText("Melissa Nelson");
			 medium.setText("HEAD OF ART");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"menelson@lwsd.org"});
			 builder.setMessage(" My work career has included: 3 years as a police dispatcher/booking officer in Sitka, Alaska, 13 years as a Scientific Computer Programmer at Boeing, 10 years as an artist/craftsman working for myself.");
		 }
		 
		 else if (teacher == 20) {
			 changer.setImageResource(R.drawable.waar);
			 large.setText("Samantha Waardhuizin");
			 medium.setText("ART TEACHER");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"svanwaardhuizen@lwsd.org"});
			 builder.setMessage("I am both from Wisconsin and a child of the 90's. Before moving to the Seattle area, I taught high school Drawing, Graphic Design, and Web Design. ");
		 }
		 
		 else if (teacher == 21) {
			 changer.setImageResource(R.drawable.ditolla);
			 large.setText("Diana Di-Tolla");
			 medium.setText("HEAD OF SPANISH");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"dditolla@lwsd.org"});
			 builder.setMessage(" I was very attracted to pursuing a career in botany but I decided to become a teacher instead. I participated in the Kid Reach program, whereby college students are sent to inner-city schools with strong minority representation, and assisted in Spanish and biology classes at Rainier High School and Ballard High School. ");
		 }
		 
		 else if (teacher == 22) {
			 changer.setImageResource(R.drawable.miranda);
			 large.setText("Nadia Miranda");
			 medium.setText("HEAD OF SPANISH");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"nmirandanavas@lwsd.org"});
			 builder.setMessage("I was born and raised in San José, Costa Rica. My parents had the wonderful vision of sending us to the German School, providing a bicultural education and promoting my love for everything different. ");
		 }

		 else if (teacher == 23) {
			 changer.setImageResource(R.drawable.ensign);
			 large.setText("Mike Ensign");
			 medium.setText("JANITOR");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mensign@lwsd.org"});
			 builder.setMessage("*Custodian*");
		 }
		 
		 else if (teacher == 24) {
			 changer.setImageResource(R.drawable.winard);
			 large.setText("Nicole Winard");
			 medium.setText("LIBRARIAN");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"nwinard@lwsd.org"});
			 builder.setMessage("*Librarian*");
		 }
		 
		 else if (teacher == 25) {
			 changer.setImageResource(R.drawable.haley);
			 large.setText("Erin Haley");
			 medium.setText("OFFICE HELP");
			 emailer.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ehaley@lwsd.org "});
			 builder.setMessage("I was born and raised in Joliet, IL, which is about 45 minutes south of Chicago. I taught special education in Illinois for eight years before a move to Washington brought me to ICS in 2011. ");
		 }
		 
} 
	public static void setTeacher(int teach) {
		teacher = teach;	
	}

}

