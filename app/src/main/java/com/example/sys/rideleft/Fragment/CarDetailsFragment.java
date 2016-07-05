package com.example.sys.rideleft.Fragment;


import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sys.rideleft.MainActivity;
import com.example.sys.rideleft.R;
import com.example.sys.rideleft.Adapter.SlidingImage_Adapter;
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
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.car_details,container,false);
        base_fare=(TextView)v.findViewById(R.id.base_fare);
        base_fare.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        mPager = (ViewPager) v.findViewById(R.id.pager);
        indicator = (CirclePageIndicator)v.findViewById(R.id.indicator);
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        mPager.setAdapter(new SlidingImage_Adapter(getContext(),ImagesArray));
        indicator.setViewPager(mPager);
        ActionBar bar = ((ActionBarActivity)getActivity()).getSupportActionBar();

        MainActivity.chk();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9402242A")));
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                return true;
            default:

        }
        return true;
    }


    /*@Override
    public void onCreateOptionsMenu( Menu menu, MenuInflater inflater ) {
       // inflater.inflate(R.m.dummy_menu,menu);
        super.onCreateOptionsMenu( menu, inflater );
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // System.out.println("DDDDDDDDDDDDDDDDDDD  "+item.getItemId());

        switch (item.getItemId())
        {
            case android.R.id.home:


                System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
              //  System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");

                return true;
            default:

        }
        return true;
    }

    @Override
    public void onBackStackChanged() {

    }*/
}
