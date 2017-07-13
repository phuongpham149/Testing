package com.example.asiantech.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.Object;

/**
 * Copyright@ AsianTech.Inc
 * Created by Phuong Pham T. on 11/07/2017.
 */
public class IntroducePagerAdapter extends PagerAdapter {
    private int[] mImages= {R.drawable.introduce_1,R.drawable.introduce_2,R.drawable.introduce_3,R.drawable.introduce_4};
    private Activity mActivity;

    public IntroducePagerAdapter(Activity activity) {
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return mImages.length+1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_viewpager_introduce, container, false);

        LinearLayout llContainer = (LinearLayout)itemView.findViewById(R.id.llContainer);
        ImageView imgIntro = (ImageView) itemView.findViewById(R.id.image);
        Button btnStart = (Button) itemView.findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity,UsePoint.class);
                mActivity.startActivity(intent);
            }
        });

        if(position < mImages.length){
            llContainer.setVisibility(View.GONE);
            imgIntro.setVisibility(View.VISIBLE);
            imgIntro.setImageResource(mImages[position]);
        } else{
            llContainer.setVisibility(View.VISIBLE);
            imgIntro.setVisibility(View.GONE);
        }
        container.addView(itemView);
        return itemView;
    }
}
