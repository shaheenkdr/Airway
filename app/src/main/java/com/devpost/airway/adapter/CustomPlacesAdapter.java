package com.devpost.airway.adapter;

import android.content.Context;
import android.graphics.Typeface;

import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import com.devpost.airway.R;
import com.devpost.airway.places_api.Result;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomPlacesAdapter extends RecyclerView.Adapter<CustomPlacesAdapter.HotelsViewHolder>
{



    private DataHolder d2 = new DataHolder();

    public class HotelsViewHolder extends RecyclerView.ViewHolder
    {
        private TextView hotelName;
        private Typeface face;
        private ImageView hotel_logo;
        private Context mcontext;

        HotelsViewHolder(View itemView)
        {
            super(itemView);
            mcontext = itemView.getContext();
            hotelName = (TextView)itemView.findViewById(R.id.hotelName);
            face = Typeface.createFromAsset(itemView.getContext().getAssets(), "Fonts/Roboto-Regular.ttf");
            hotelName.setTypeface(face);
            hotel_logo = (ImageView)itemView.findViewById(R.id.logoOfHotel);
        }



    }

    private static class DataHolder
    {
        List<Result> feeds;

    }



    public CustomPlacesAdapter(List<Result> feeds)
    {
        this.d2.feeds = feeds;
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public HotelsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_item, viewGroup, false);
        HotelsViewHolder pvh = new HotelsViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(HotelsViewHolder feedViewHolder, int i)
    {
        Log.e("SIZE",""+d2.feeds.size());
        feedViewHolder.hotelName.setText(d2.feeds.get(i).getName());
        Picasso.with(feedViewHolder.mcontext).load(d2.feeds.get(i).getIcon()).into(feedViewHolder.hotel_logo);

    }

    @Override
    public int getItemCount()
    {

        if(d2.feeds!=null)
        {
            return d2.feeds.size();
        }
        else
        {
            return 0;
        }
    }



}