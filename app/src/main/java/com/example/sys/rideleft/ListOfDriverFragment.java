package com.example.sys.rideleft;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sys.leftriding.R;

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
    List<DriverDetails> flowers;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.content_fragment,container,false);
        collapsingToolbarLayout=(CollapsingToolbarLayout)v.findViewById(R.id.collapsing_toolbar);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerView);


        //  toolbar = (Toolbar) v.findViewById(R.id.toolbar);

        //  collapsingToolbarLayout.setTitle("Demo");
        //((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        recyclerView.setNestedScrollingEnabled(false);

        //  recyclerView.setNestedScrollingEnabled(false);
        initializeData();

        adapter = new CardAdapter(flowers);

        //set adapter
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new LineDivider(getResources()));
        return v;
    }

    private void initializeData()
    {
        flowers = new ArrayList<>();
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
        flowers.add(new DriverDetails("Ram Pathak"));
    }
}
