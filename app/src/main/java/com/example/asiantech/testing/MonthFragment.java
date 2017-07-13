package com.example.asiantech.testing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

/**
 * Copyright@ AsianTech.Inc
 * Created by Phuong Pham T. on 12/07/2017.
 */
public class MonthFragment extends Fragment {

    private RecyclerView mRecyclerViewCalendar;
    private static final int MAXIMUM_DAYS_IN_WEEK = 7;
    private CalendarRecyclerAdapter mAdapter;
    private Calendar mCalendar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager_calendar, container);
        Log.d(getClass().getSimpleName(),"================= fragment month");
        mRecyclerViewCalendar = (RecyclerView) view.findViewById(R.id.recyclerViewCalendar);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), MAXIMUM_DAYS_IN_WEEK);
        mRecyclerViewCalendar.setLayoutManager(layoutManager);

        mCalendar = Calendar.getInstance();

        mAdapter = new CalendarRecyclerAdapter(getActivity(), mCalendar);
        mRecyclerViewCalendar.setAdapter(mAdapter);
        return view;
    }
}
