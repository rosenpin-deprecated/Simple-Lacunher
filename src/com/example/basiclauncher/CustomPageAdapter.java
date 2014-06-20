package com.example.basiclauncher;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.*;

public class CustomPageAdapter extends PagerAdapter {
    private static View view;
    ViewGroup parent;

    public Object instantiateItem(View collection, int position) {
        LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int resId = 0;
        int mainId = 0;
        switch (position) {
            case 0: {
                resId = R.layout.page_one;

                break;
            }
            case 1: {
                resId = R.layout.page_two;
                break;
            }
            case 2: {
                resId = R.layout.page_three;
                break;
            }
            case 3:
            {
                resId = R.layout.maps_load;
                break;
            }
        }
        System.out.println("view is"+resId);
        view = inflater.inflate(resId, null);
        ((ViewPager) collection).addView(view, 0);
        return view;

    }
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }
    @Override
    public Parcelable saveState() {
        return null;
    }
    @Override
    public int getCount() {
        return 4;
    }

}
