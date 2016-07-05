package com.example.sys.rideleft.Fragment;

import android.app.FragmentManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.sys.rideleft.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by sys on 6/20/2016.
 */
public class HomeFragment extends Fragment
{
    GoogleMap map;

    int ICONS[] = {
            R.drawable.face,
            R.drawable.face,
            R.drawable.face,
            R.drawable.face,
            R.drawable.face,
            R.drawable.face,
            R.drawable.face
    };
    LinearLayout sv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_frag,container,false);

        map = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.maps_Location)).getMap();

         sv = (LinearLayout) v.findViewById (R.id.images);
        //FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) sv.getLayoutParams();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(120, 120);

     //   params.setMargins(10,0,0,10);


        for (int i=0 ; i<ICONS.length; i++)
        {
            ImageView imageView = new ImageView(getContext());
            imageView.setId(i);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setLayoutParams(layoutParams);


            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), ICONS[i]));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            sv.addView(imageView);

        }
        return v;
    }
}
