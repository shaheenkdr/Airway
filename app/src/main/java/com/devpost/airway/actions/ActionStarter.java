package com.devpost.airway.actions;


import android.content.Context;
import android.content.Intent;

import com.devpost.airway.activities.WebViewActivity;
import com.devpost.airway.flappybirdgame.FlappyBirdGame;
import com.devpost.airway.two.TwoGameActivity;

import java.util.Random;

public class ActionStarter
{
    private Context mContext;
    private int event_code;
    private static final String BOOK_URL = "https://www.airberlin.com/en/booking/flight/vacancy.php";

    public ActionStarter(Context mContext,int event_code)
    {
        this.mContext = mContext;
        this.event_code = event_code;
        doAction();
    }

    private void doAction()
    {
        Intent myIntent;
        if(event_code==1)
        {
            myIntent = new Intent(mContext, WebViewActivity.class);
            myIntent.putExtra("URL",BOOK_URL);
            mContext.startActivity(myIntent);

        }
        else if(event_code==2)
        {

        }
        else if(event_code==3)
        {
            Random ran = new Random();
            int x = ran.nextInt(5000);
            if(x%2==0)
            {
                myIntent = new Intent(mContext, TwoGameActivity.class);
                mContext.startActivity(myIntent);
            }
            else
            {
                myIntent = new Intent(mContext, FlappyBirdGame.class);
                mContext.startActivity(myIntent);
            }

        }
        else if(event_code==5)
        {

        }
        else if(event_code==6)
        {

        }
        else if(event_code==9)
        {

        }
    }

}
