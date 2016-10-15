package com.devpost.airway.adapter;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devpost.airway.R;
import com.devpost.airway.utility.Text;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.FeedsViewHolder>
{



    DataHolder d1 = new DataHolder();

    public  class FeedsViewHolder extends RecyclerView.ViewHolder
    {
        private TextView chat;
        private Typeface face;
        private Context mcontext;

        FeedsViewHolder(View itemView)
        {
            super(itemView);
            mcontext = itemView.getContext();
            chat = (TextView)itemView.findViewById(R.id.chatMessage);
            face = Typeface.createFromAsset(itemView.getContext().getAssets(), "Fonts/Roboto-Regular.ttf");
            chat.setTypeface(face);


        }



    }

    private static class DataHolder
    {
        List<Text> feeds;

    }



    public CustomAdapter(List<Text> feeds)
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
        RelativeLayout.LayoutParams params =
                (RelativeLayout.LayoutParams)feedViewHolder.chat.getLayoutParams();

        if(d1.feeds.get(i).isMachineOrHuman())
        {
            params.addRule(RelativeLayout.ALIGN_PARENT_START);
            feedViewHolder.chat.setLayoutParams(params);
            feedViewHolder.chat.setGravity(Gravity.START);
            feedViewHolder.chat.setBackground(ContextCompat.getDrawable(feedViewHolder.mcontext, R.drawable.user));
            feedViewHolder.chat.setText(d1.feeds.get(i).getMessage());
        }

        else
        {
            params.addRule(RelativeLayout.ALIGN_PARENT_END);
            feedViewHolder.chat.setLayoutParams(params);
            feedViewHolder.chat.setGravity(Gravity.END);
            feedViewHolder.chat.setBackground(ContextCompat.getDrawable(feedViewHolder.mcontext, R.drawable.ais));
            feedViewHolder.chat.setText(d1.feeds.get(i).getMessage());
        }



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
