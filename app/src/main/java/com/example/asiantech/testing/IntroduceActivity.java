package com.example.asiantech.testing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Copyright@ AsianTech.Inc
 * Created by Phuong Pham T. on 11/07/2017.
 */
public class IntroduceActivity extends AppCompatActivity {
    ViewPager mViewPagerIntroduce;
    TextView mTvTitle;
    TextView mTvContent;
    ImageView mImgIndicator;
    LinearLayout mLlDescription;

    private int[] mIndicators = {R.drawable.indicator_1,R.drawable.indicator_2,R.drawable.indicator_3,R.drawable.indicator_4};
    private String[] mTitles ;
    private String[] mContents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        mTitles = getResources().getStringArray(R.array.title);
        mContents = getResources().getStringArray(R.array.content);

        mViewPagerIntroduce = (ViewPager) findViewById(R.id.viewPagerIntroduce);
        mTvTitle = (TextView) findViewById(R.id.title);
        mTvContent = (TextView) findViewById(R.id.content);
        mImgIndicator = (ImageView) findViewById(R.id.indicator);
        mLlDescription = (LinearLayout) findViewById(R.id.llDescription);

        mViewPagerIntroduce.setAdapter(new IntroducePagerAdapter(this));

        mViewPagerIntroduce.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == mIndicators.length){
                    mLlDescription.setVisibility(View.GONE);
                }else{
                    mLlDescription.setVisibility(View.VISIBLE);
                    mTvTitle.setText(mTitles[position]);
                    mTvContent.setText(mContents[position]);
                    mImgIndicator.setImageResource(mIndicators[position]);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
