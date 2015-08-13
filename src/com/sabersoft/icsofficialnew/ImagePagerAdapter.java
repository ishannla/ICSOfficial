package com.sabersoft.icsofficialnew;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagePagerAdapter extends PagerAdapter {
    
	//Compiles the Images into an Image Slider
	private int[] mImages = new int[] {
    			R.drawable.icstotal,  
    			R.drawable.camptotal,
    	        R.drawable.fblagrouptotal,
    	        R.drawable.harvesttotal,
    	        R.drawable.fblaexectotal,
    };

    @Override
    public int getCount() {
      return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
      return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      Context context = container.getContext();
      ImageView imageView = new ImageView(context);
      int padding = context.getResources().getDimensionPixelSize(
          R.dimen.padding_medium);
      imageView.setPadding(padding, padding, padding, padding);
      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      imageView.setImageResource(mImages[position]);
      ((ViewPager) container).addView(imageView, 0);
      return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      ((ViewPager) container).removeView((ImageView) object);
    }
  }