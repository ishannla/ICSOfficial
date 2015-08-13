package com.sabersoft.icsofficialnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class ContactFragment extends Fragment{
	
	//Define all of the different buttons for each teacher 
	Button moncadaButton; 
	Button petersonButton;
	Button austinButton;
	Button christiansenButton;
	Button sharmaButton;
	Button mcfaulButton; 
	Button vasiliaButton;
	Button sullivanButton;
	Button henryButton;
	Button gibsonButton; 
	Button lentzButton;
	Button packerButton; 
	Button plankButton;
	Button castanedaButton;
	Button garmanButton;
	Button bachButton; 
	Button elliottButton; 
	Button overButton;
	Button rayderButton;
	Button nelsonButton;
	Button waarButton;
	Button ditollaButton;
	Button mirandaButton;
	Button ensignButton;
	Button winardButton;
	Button haleyButton;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.contact, container, false);
		
		//Assign each button to its individual ID 
		petersonButton = (Button) rootView.findViewById(R.id.HP);
		austinButton = (Button) rootView.findViewById(R.id.SA);
		christiansenButton = (Button) rootView.findViewById(R.id.LC);
		sharmaButton = (Button) rootView.findViewById(R.id.MS);
		mcfaulButton = (Button) rootView.findViewById(R.id.TM);
		vasiliaButton = (Button) rootView.findViewById(R.id.JV);
		sullivanButton = (Button) rootView.findViewById(R.id.NS);
		henryButton = (Button) rootView.findViewById(R.id.HH);
		gibsonButton = (Button) rootView.findViewById(R.id.GG);
		lentzButton = (Button) rootView.findViewById(R.id.ML);
		packerButton = (Button) rootView.findViewById(R.id.AP);
		plankButton = (Button) rootView.findViewById(R.id.PP);
		castanedaButton = (Button) rootView.findViewById(R.id.VC);
		garmanButton = (Button) rootView.findViewById(R.id.BG);
		bachButton = (Button) rootView.findViewById(R.id.MB);
		elliottButton = (Button) rootView.findViewById(R.id.ME);
		overButton = (Button) rootView.findViewById(R.id.TO);
		rayderButton = (Button) rootView.findViewById(R.id.MR);
		nelsonButton = (Button) rootView.findViewById(R.id.MN);
		waarButton = (Button) rootView.findViewById(R.id.SV);
		ditollaButton = (Button) rootView.findViewById(R.id.DD);
		mirandaButton = (Button) rootView.findViewById(R.id.NM);
		ensignButton = (Button) rootView.findViewById(R.id.MikeE);
		winardButton = (Button) rootView.findViewById(R.id.NW);
		haleyButton = (Button) rootView.findViewById(R.id.EH);
		
		 final ImageView changer  = (ImageView) rootView.findViewById(R.id.imageChanger);
		
		 //Assign button to individual ID 
		 moncadaButton = (Button) rootView.findViewById(R.id.GM);
		 
		 //Create an OnClickListener for button to navigate activities
		moncadaButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//showNotification();
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(0);
	            startActivity(intent);
			}});
		
		petersonButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(1);
	            startActivity(intent);
			}});
		
		austinButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(2);
	            startActivity(intent);
			}});
		
		christiansenButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(3);
	            startActivity(intent);
			}});
		
		sharmaButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(4);
	            startActivity(intent);
			}});
		
		mcfaulButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(5);
	            startActivity(intent);
			}});
		
		vasiliaButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(6);
	            startActivity(intent);
			}});
		
		sullivanButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(7);
	            startActivity(intent);
			}});
		
		henryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(8);
	            startActivity(intent);
			}});
		
		gibsonButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(9);
	            startActivity(intent);
			}});
		
		lentzButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(10);
	            startActivity(intent);
			}});
		
		packerButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(11);
	            startActivity(intent);
			}});
		
		plankButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(12);
	            startActivity(intent);
			}});
		
		castanedaButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(13);
	            startActivity(intent);
			}});
		
		garmanButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(14);
	            startActivity(intent);
			}});
		
		bachButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(15);
	            startActivity(intent);
			}});
		
		elliottButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(16);
	            startActivity(intent);
			}});
		
		overButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(17);
	            startActivity(intent);
			}});
		
		rayderButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(18);
	            startActivity(intent);
			}});
		
		nelsonButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(19);
	            startActivity(intent);
			}});
		
		waarButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(20);
	            startActivity(intent);
			}});
		
		ditollaButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(21);
	            startActivity(intent);
			}});
		
		mirandaButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(22);
	            startActivity(intent);
			}});
		
		ensignButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(23);
	            startActivity(intent);
			}});
		
		winardButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(24);
	            startActivity(intent);
			}});
		
		haleyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TeacherList.class);
				TeacherList.setTeacher(25);
	            startActivity(intent);
			}});
		
		
		return rootView;
	}

}
