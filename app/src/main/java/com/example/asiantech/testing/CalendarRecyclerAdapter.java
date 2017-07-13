package com.example.asiantech.testing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Copyright@ AsianTech.Inc
 * Created by Phuong Pham T. on 12/07/2017.
 */
public class CalendarRecyclerAdapter extends RecyclerView.Adapter<CalendarRecyclerAdapter.holder> {
    private static final int MAXIMUM_ROW = 5;

    private Calendar mCalendar;
    private int position = 0;

    private Context mContext;

    public CalendarRecyclerAdapter(Context mContext, Calendar calendar) {
        Log.d(getClass().getSimpleName(),"====================");
        this.mContext = mContext;
        mCalendar = calendar;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {
        //ngay thang hien tai
        //ngay 1 -> thu may -> hien thi len
//        holder.mTvDate.setText(position+1);


    }

    @Override
    public int getItemCount() {
        return mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    class holder extends RecyclerView.ViewHolder {
        TextView mTvDate;

        public holder(View itemView) {
            super(itemView);
            mTvDate = (TextView) itemView.findViewById(R.id.tvDate);
        }
    }
}
