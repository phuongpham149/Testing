package com.example.asiantech.testing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Calendar;

/**
 * Copyright@ AsianTech.Inc
 * Created by Phuong Pham T. on 12/07/2017.
 */
public class CalendarActivity extends AppCompatActivity {
    private ViewPager mViewPagerCalendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        mViewPagerCalendar = (ViewPager) findViewById(R.id.viewPagerCalendar);


        Calendar calendar = Calendar.getInstance();
        Log.d(getClass().getSimpleName(),"----- "+calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        mViewPagerCalendar.setAdapter(new CalendarPagerAdapter(getSupportFragmentManager()));
    }
}
