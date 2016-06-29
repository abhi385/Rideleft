package com.example.sys.rideleft;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sys.leftriding.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

/**
 * Created by sys on 6/23/2016.
 */
public class CarDetailsFragment extends Fragment
{
    TextView base_fare;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.car_first,R.drawable.car_second,R.drawable.car_third,R.drawable.car_fourth};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    CirclePageIndicator indicator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.car_details,container,false);
        base_fare=(TextView)v.findViewById(R.id.base_fare);
        base_fare.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        mPager = (ViewPager) v.findViewById(R.id.pager);
        indicator = (CirclePageIndicator) v.findViewById(R.id.indicator);
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        mPager.setAdapter(new SlidingImage_Adapter(getContext(),ImagesArray));
        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int pos) {
            }
        });
        return v;
    }
}
