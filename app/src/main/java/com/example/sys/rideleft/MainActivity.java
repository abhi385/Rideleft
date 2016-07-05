package com.example.sys.rideleft;



import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.sys.rideleft.Adapter.EventListRecylerView;
import com.example.sys.rideleft.Fragment.CarDetailsFragment;
import com.example.sys.rideleft.Fragment.HomeFragment;
import com.example.sys.rideleft.Fragment.ListOfDriverFragment;
import com.example.sys.rideleft.Fragment.RideDetailsFragment;
import com.example.sys.rideleft.Other.DividerItemDecoration;


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
    static  DrawerLayout Drawer;                                  // Declaring DrawerLayout
    static  ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
       /*  getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.tool_bar);

      //  toolbar.getBackground().setAlpha(0);
        setSupportActionBar(toolbar);


      /*  toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
                onBackPressed();
            }
        });*/
        //setHasOptionsMenu(true);
        //toolbar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
/*        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSS");

            }
        });*/

        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Home");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        getSupportActionBar().setDisplayShowTitleEnabled(false);
      //  getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //getSupportActionBar().setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#550000ff")));
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View
        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size
        mAdapter = new EventListRecylerView(TITLES,ICONS,NAME,PROFILE);       // Creating the Adapter of EventListRecylerView class(which we are going to see in a bit)
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getResources()));
        // Setting the adapter to RecyclerView

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);

        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,R.string.openDrawer,R.string.closeDrawer)
        {

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }
         };

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerToggle.syncState();
        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
       /* toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getSupportFragmentManager().getBackStackEntryCount() > 0){
                    getSupportFragmentManager().popBackStack();
                }else {
                }
            }
        });*/
       /* mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // event when click home button
                  //  finish();

                System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLL");
           //     popStackIfNeeded();
            }
        });*/
      /*  Drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mDrawerToggle.onDrawerStateChanged(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);*/
        /**/
     //   toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back));

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)
            {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());



                if(child!=null && mGestureDetector.onTouchEvent(motionEvent))
                {
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



     /*   getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);*/



      //  getSupportActionBar().beginTransaction().add(R.id.frame_container,fragment, "First").addToBackStack(null).commit();
       // getFragmentManager().addOnBackStackChangedListener(getBaseContext());



        /*getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                        public void onBackStackChanged()
                        {
                            System.out.println("SSSSSSSSSSSSSSSSSSSSSSS");
                        }
                });*/
        // Finally we set the drawer toggle sync State

    }


    public static void chk()
    {
        Drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        */
        mDrawerToggle.setDrawerIndicatorEnabled(false);
      //  mDrawerToggle.onDrawerStateChanged(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }
    /*@Override
    public void onBackPressed() {
        super.onBackPressed();

        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    }*/


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
         super.onPostCreate(savedInstanceState);
         mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
          super.onConfigurationChanged(newConfig);
          mDrawerToggle.onConfigurationChanged(newConfig);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
    */

    private void displayView(int position)
    {
        Fragment fragment = null;
        switch (position)
        {
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
                fragment = new RideDetailsFragment();
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

        if(fragment != null)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            //transaction.addToBackStack(null);
            transaction.replace(R.id.fragment_trans, fragment).commit();
            mTitle.setText(TITLES[position-1]);
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