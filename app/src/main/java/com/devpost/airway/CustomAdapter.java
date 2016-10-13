package com.devpost.airway;


import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.FeedsViewHolder>
{



    DataHolder d1 = new DataHolder();

    public  class FeedsViewHolder extends RecyclerView.ViewHolder
    {
        private TextView chat;
        private Typeface face;

        FeedsViewHolder(View itemView)
        {
            super(itemView);

            chat = (TextView)itemView.findViewById(R.id.chatMessage);
            //face = Typeface.createFromAsset(itemView.getContext().getAssets(), "Fonts/Roboto-Regular.ttf");
            //chat.setTypeface(face);


        }



    }

    private static class DataHolder
    {
        List<Text> feeds;

    }



    CustomAdapter(List<Text> feeds)
    {
        this.d1.feeds = feeds;
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public FeedsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message, viewGroup, false);
        FeedsViewHolder pvh = new FeedsViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(FeedsViewHolder feedViewHolder, int i)
    {
        if(d1.feeds.get(i).isMachineOrHuman())
        {
            feedViewHolder.chat.setBackgroundResource(R.drawable.user);
            feedViewHolder.chat.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
        }

        else
            feedViewHolder.chat.setBackgroundResource(R.drawable.ais);


        feedViewHolder.chat.setText(d1.feeds.get(i).getMessage());

    }

    @Override
    public int getItemCount()
    {

        if(d1.feeds!=null)
        {
            return d1.feeds.size();
        }
        else
        {
            return 0;
        }
    }



}
