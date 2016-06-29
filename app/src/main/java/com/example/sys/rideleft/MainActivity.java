package com.example.sys.rideleft;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.sys.leftriding.R;


public class MainActivity extends ActionBarActivity
{

    //First We Declare Titles And Icons For Our Navigation Drawer List View
    //This Icons And Titles Are holded in an Array as you can see

    String TITLES[] = {"Home","Rides","Free Rides","Rideleft Money","Payment","Support","Settings"};
    int ICONS[] = {R.drawable.ic_delete_black,
            R.drawable.ic_drafts_black,
            R.drawable.ic_email_black,
            R.drawable.ic_error_black,
            R.drawable.ic_email_black,
            R.drawable.ic_email_black,
            R.drawable.ic_email_black};

    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header view

    String NAME = "Security Escape";
    int PROFILE = R.drawable.logo;

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new MyAdapter(TITLES,ICONS,NAME,PROFILE);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getResources()));
        // Setting the adapter to RecyclerView

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);

        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer)
        {

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
         };




        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());



                if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
                    Drawer.closeDrawers();

                 //   Toast.makeText(MainActivity.this,"The Item Clicked is: "+recyclerView.getChildPosition(child),Toast.LENGTH_SHORT).show();
                     displayView(recyclerView.getChildPosition(child));

                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        displayView(1);


        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State

    }


    private void displayView(int position)
    {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 1:
                fragment = new HomeFragment();
                break;
            case 2:
                fragment = new ListOfDriverFragment();
                break;
            case 3:
                fragment = new CarDetailsFragment();
                break;
            case 4:
                fragment = new ListOfDriverFragment();
                break;
            case 5:
                fragment = new ListOfDriverFragment();
                break;
            case 6:
                fragment = new ListOfDriverFragment();
                break;
            case 7:
                fragment = new ListOfDriverFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
       FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_trans, fragment).commit();
            // update selected item and title, then close the drawer
           // mDrawerList.setItemChecked(position, true);
            //mDrawerList.setSelection(position);
           // setTitle(navMenuTitles[position]);
            toolbar.setTitle(TITLES[position-1]);
            Drawer.closeDrawer(mRecyclerView);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
    /*private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }*/
}