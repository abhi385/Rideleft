package com.example.sys.rideleft.Fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sys.rideleft.Adapter.CardAdapter;
import com.example.sys.rideleft.GetSet.DriverDetails;
import com.example.sys.rideleft.MainActivity;
import com.example.sys.rideleft.Other.LineDivider;
import com.example.sys.rideleft.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sys on 7/5/2016.
 */
public class RideDetailsFragment extends Fragment {
    // Toolbar toolbar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.ridefragment,container,false);
        ActionBar bar = ((ActionBarActivity)getActivity()).getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9402242A")));
        return v;
    }


/*    private void initializeData()
    {
        driver = new ArrayList<>();
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
        driver.add(new DriverDetails("Ram Pathak"));
    }*/


}