package com.example.sys.rideleft;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sys.leftriding.R;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
    // IF the view under inflation and population is header or Item
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;

    private String mNavTitles[]; // String Array to store the passed titles Value from MainActivity.java
    private int mIcons[];       // Int Array to store the passed icons resource value from MainActivity.java

    private String name;        //String Resource for header View Name
    private int profile;        //int Resource for header view profile picture
    private String email;       //String Resource for header view email


    // Creating a ViewHolder which extends the RecyclerView View Holder
    // ViewHolder are used to to store the inflated views in order to recycle them

    /*public static class ViewHolder extends RecyclerView.ViewHolder {
        int Holderid;

        TextView textView,textViews;
        ImageView imageView;
        ImageView profile;
        TextView Name;



        public ViewHolder(View itemView, int ViewType) {                 // Creating ViewHolder Constructor with View and viewType As a parameter
            super(itemView);


            // Here we set the appropriate view in accordance with the the view type as passed when the holder object is created
            if(ViewType == TYPE_FOOTER) {
                textViews = (TextView) itemView.findViewById(R.id.row); // Creating TextView object with the id of textView from item_row.xml
                Holderid=2;
            }
            if(ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText); // Creating TextView object with the id of textView from item_row.xml
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);// Creating ImageView object with the id of ImageView from item_row.xml
                Holderid = 1;                                               // setting holder id as 1 as the object being populated are of type item row
            }
            else{



                Name = (TextView) itemView.findViewById(R.id.name);         // Creating Text View object from header.xml for name
                 // Creating Text View object from header.xml for email
                profile = (ImageView) itemView.findViewById(R.id.circleview);// Creating Image view object from header.xml for profile pic
                Holderid = 0;                                                // Setting holder id = 0 as the object being populated are of type header view
            }
        }


    }
*/

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitleHeader;
        ImageView profile;
        public HeaderViewHolder (View itemView) {
            super (itemView);
            this.txtTitleHeader = (TextView) itemView.findViewById (R.id.name);
            this.profile = (ImageView) itemView.findViewById (R.id.circleview);

        }
    }

    class GenericViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;


        public GenericViewHolder (View itemView) {
            super (itemView);
            textView = (TextView) itemView.findViewById (R.id.rowText);
            imageView = (ImageView) itemView.findViewById (R.id.rowIcon);
            int color = Color.parseColor("#FFFFFF"); //The color u want
            imageView.setColorFilter(color);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitleFooter;

        public FooterViewHolder (View itemView) {
            super (itemView);
            this.txtTitleFooter = (TextView) itemView.findViewById (R.id.terms);
        }
    }
    MyAdapter(String Titles[], int Icons[], String Name, int Profile){ // MyAdapter Constructor with titles and icons parameter
        // titles, icons, name, email, profile pic are passed from the main activity as we
        mNavTitles = Titles;                //have seen earlier
        mIcons = Icons;
        name = Name;


        profile = Profile;                     //here we assign those passed values to the values we declared here
        //in adapter



    }





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.header, parent, false);
            return new HeaderViewHolder (v);
        } else if(viewType == TYPE_FOOTER) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.temp, parent, false);
            return new FooterViewHolder (v);
        } else if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_row, parent, false);
            return new GenericViewHolder (v);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if(holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.txtTitleHeader.setText ("SecurityEscape");
            headerHolder.profile.setImageResource(profile);


        } else if(holder instanceof FooterViewHolder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;
         //   footerHolder.txtTitleFooter.setText ("Footer");


        } else if(holder instanceof GenericViewHolder) {

            GenericViewHolder genericViewHolder = (GenericViewHolder) holder;
            genericViewHolder.textView.setText(mNavTitles[position - 1]); // Setting the Text with the array of our Titles
            genericViewHolder.imageView.setImageResource(mIcons[position -1]);


        }
    }

    //Next we override a method which is called when the item in a row is needed to be displayed, here the int position
    // Tells us item at which position is being constructed to be displayed and the holder id of the holder object tell us
    // which view type is being created 1 for item row
    /*@Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

         if(holder.Holderid ==0){


             //holder.profile.setImageResource(R.drawable.logo);

//            holder.profile.setImageResource(profile);           // Similarly we set the resources for header view
           holder.Name.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        }
        else if(holder.Holderid ==1) {
             System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKK");

             // as the list view is going to be called after the header view so we decrement the
            // position by 1 and pass it to the holder while setting the text and image
            holder.textView.setText(mNavTitles[position - 1]); // Setting the Text with the array of our Titles
            holder.imageView.setImageResource(mIcons[position -1]);// Settimg the image with array of our icons
        }else  if(holder.Holderid ==2) {                              // as the list view is going to be called after the header view so we decrement the
            // position by 1 and pass it to the holder while setting the text and image
            holder.textViews.setText("SSSSSSSSSSSSS"); // Setting the Text with the array of our Titles
        }

    }*/

    // This method returns the number of items present in the list
    @Override
    public int getItemCount()
    {
        return mNavTitles.length+2; // the number of items in the list will be +1 the titles including the header view.
    }

    private boolean isPositionFooter (int position)
    {
        return position == mNavTitles.length+1;
    }
    // Witht the following method we check what type of view is being passed
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
        {
            return TYPE_HEADER;

        }
        else if(isPositionFooter(position)) {
            return TYPE_FOOTER;
        }

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}