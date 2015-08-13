package com.sabersoft.icsofficialnew;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home, container, false);
		Button studentResources = (Button) rootView.findViewById(R.id.studentResources);
		TextView announcements = (TextView) rootView.findViewById(R.id.TextViewAnnouncements);
		String htmlString="<u>School Announcements</u>";
		announcements.setText(Html.fromHtml(htmlString));
		
		 ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
	     ImagePagerAdapter adapter = new ImagePagerAdapter();
  	     viewPager.setAdapter(adapter);
	
		//Navigate to the StudentResources Activity if clicked
		studentResources.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//showNotification();
				Intent intentDates = new Intent().setClass(getActivity(), StudentResources.class);
				startActivity(intentDates);
			}
		});
	
		return rootView;
	}
	
	
}
