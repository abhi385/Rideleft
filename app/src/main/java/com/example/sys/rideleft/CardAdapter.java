package com.example.sys.rideleft;

/**
 * Created by sys on 6/21/2016.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sys.leftriding.R;

import java.util.ArrayList;
import java.util.List;
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
        List<DriverDetails> list = new ArrayList<>();
        public CardAdapter(List<DriverDetails> list)
        {
            this.list = list;
        }
        @Override
        public int getItemCount()
        {
                return list.size();
        }
        public DriverDetails getItem(int i)
        {
                return list.get(i);
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
                View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
                return new ViewHolder(itemView);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position)
        {

                holder.Flower=getItem(position);
                holder.name.setText(list.get(position).name);

                }
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
                super.onAttachedToRecyclerView(recyclerView);
                }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView cardimage;
            TextView cardtitle,name,star,price,typeofcar;
            DriverDetails Flower;
            public ViewHolder(View itemView) {
                super(itemView);
                cardimage = (ImageView) itemView.findViewById(R.id.cardimage);
                name=(TextView)itemView.findViewById(R.id.name);
                star=(TextView)itemView.findViewById(R.id.star);
                price=(TextView)itemView.findViewById(R.id.price);
                typeofcar=(TextView)itemView.findViewById(R.id.typesofcar);
                // cardtitle = (TextView) itemView.findViewById(R.id.cardtitle);
            }
        }
}