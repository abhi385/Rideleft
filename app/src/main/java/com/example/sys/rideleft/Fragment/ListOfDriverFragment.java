package com.example.sys.rideleft.Fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sys.rideleft.Adapter.CardAdapter;
import com.example.sys.rideleft.GetSet.DriverDetails;
import com.example.sys.rideleft.Other.LineDivider;
import com.example.sys.rideleft.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 04-06-2015.
 */
public class ListOfDriverFragment extends Fragment {
   // Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    RecyclerView recyclerView;

    CardAdapter adapter;
    List<DriverDetails> driver;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.content_fragment,container,false);
        collapsingToolbarLayout=(CollapsingToolbarLayout)v.findViewById(R.id.collapsing_toolbar);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        recyclerView.setNestedScrollingEnabled(false);

        initializeData();

        adapter = new CardAdapter(driver);

        //set adapter
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new LineDivider(getResources()));
        return v;
    }

    private void initializeData()
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
    }
}
