package com.example.asiantech.testing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Copyright@ AsianTech.Inc
 * Created by Phuong Pham T. on 12/07/2017.
 */
public class CalendarPagerAdapter extends FragmentPagerAdapter {

    public CalendarPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new MonthFragment();
    }

    @Override
    public int getCount() {
        return 10;
    }
}
