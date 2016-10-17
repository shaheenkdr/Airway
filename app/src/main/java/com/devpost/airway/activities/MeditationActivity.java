package com.devpost.airway.activities;

import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.devpost.airway.R;

import java.util.Random;

public class MeditationActivity extends AppCompatActivity
{
    private boolean isTurnedOn;
    private MediaPlayer mPlayer;
    private ImageButton playButton;
    private ImageButton timerButton;
    private static int length;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        isTurnedOn = false;
        Random ran = new Random();
        int x = ran.nextInt(3);
        if(x==0)
        {
            mPlayer = MediaPlayer.create(this,R.raw.fst);
        }
        else if(x==1)
        {
            mPlayer = MediaPlayer.create(this,R.raw.sec);
        }
        else if(x==2)
        {
            mPlayer = MediaPlayer.create(this,R.raw.thd);
        }
        length = 0;
        try{mPlayer.prepare();}catch (Exception e){}
        playButton = (ImageButton)findViewById(R.id.playButton);
        timerButton = (ImageButton)findViewById(R.id.timerButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                if(!isTurnedOn)
                {
                    playButton.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.pause));
                    isTurnedOn = true;
                    mPlayer.start();
                    mPlayer.seekTo(length);


                }
                else
                {
                    playButton.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.play2));
                    isTurnedOn = false;
                    mPlayer.pause();
                    length = mPlayer.getCurrentPosition();
                }

            }
        });



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            if (mPlayer.isPlaying()) {
                mPlayer.stop();
            }

            mPlayer.release();
        }
        catch (Exception e){}
    }



}
