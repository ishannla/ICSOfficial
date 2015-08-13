package com.sabersoft.icsofficialnew;

import java.util.Locale;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
	
	//Designate which Fragment correlates to which Activity
	protected Context mContext;
	public SectionsPagerAdapter(Context context, FragmentManager fm) {
		 super(fm);
		mContext = context; }

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0: return new HomeFragment();
		case 1: return new EventsFragment();
		case 2: return new ContactFragment();
		case 3: return new ForumFragment();  }
		return null;  }

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0: return mContext.getString(R.string.title_section1).toUpperCase(l);
		case 1: return mContext.getString(R.string.title_section2).toUpperCase(l);
		case 2: return mContext.getString(R.string.title_section3).toUpperCase(l);
		case 3: return mContext.getString(R.string.title_section4).toUpperCase(l); }
		return null;
	}
}