package com.devpost.airway.activities;

import android.Manifest;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.devpost.airway.R;
import com.devpost.airway.actions.ActionStarter;
import com.devpost.airway.flappybirdgame.FlappyBirdGame;
import com.devpost.airway.intents.Meditate;
import com.devpost.airway.two.TwoGameActivity;
import com.devpost.airway.utility.DeveloperKey;
import com.devpost.airway.utility.ResponseX;
import com.devpost.airway.utility.Text;
import com.devpost.airway.adapter.CustomAdapter;
import com.devpost.airway.api.ApiClient;
import com.devpost.airway.api.ApiInterface;
import com.devpost.airway.bus.LuisResponseBus;
import com.devpost.airway.intents.Booking;
import com.devpost.airway.intents.Food;
import com.devpost.airway.intents.Games;
import com.devpost.airway.intents.Greetings;
import com.devpost.airway.intents.Help;
import com.devpost.airway.intents.None;
import com.devpost.airway.intents.Personal;
import com.devpost.airway.intents.Places;
import com.devpost.airway.pojo.TopScoringIntent;
import com.devpost.airway.pojo.LuisPojo;
import com.devpost.airway.utility.Util;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
{

    private Intent intent;
    private static boolean flag;
    private static final String id ="44e80599-c74c-4bc7-b30e-41730a6adfb2";
    private static final String sub_key ="3c12c7fd5d4c408ab856288e695ee5f7";
    private static final String YOUTUBE_BASE_URL = "https://www.youtube.com/watch?v=";
    private static final int REQUEST_PHONE_CALL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flag = false;


        final ScrollView scroll = (ScrollView)findViewById(R.id.scrollX);
       // scroll.post(new Runnable() { public void run() { scroll.fullScroll(View.FOCUS_DOWN); } });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            ValueAnimator realSmoothScrollAnimation =
                    ValueAnimator.ofInt(scroll.getScrollY(), 300);
            realSmoothScrollAnimation.setDuration(2000);
            realSmoothScrollAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
                @Override
                public void onAnimationUpdate(ValueAnimator animation)
                {
                    int scrollTo = (Integer) animation.getAnimatedValue();
                    scroll.scrollTo(0, scrollTo);
                }
            });

            realSmoothScrollAnimation.start();
        }
        else
        {
            scroll.smoothScrollTo(0, 300);
        }

        final CardView trackCard = (CardView)findViewById(R.id.flightTracker);
        trackCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Intent intent = new Intent(MainActivity.this,FlightTrackerActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Flight Tracker")
                        .setMessage("Would you like to track a flight?")
                        .show();


            }
        });

        final CardView delayCard = (CardView)findViewById(R.id.flightDelay);
        delayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Intent intent = new Intent(MainActivity.this,DelayIndexActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Delay Index")
                        .setMessage("Would you like to find the delay at airport?")
                        .show();

            }
        });

        final CardView foodCard = (CardView)findViewById(R.id.flightRestaurant);
        foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Intent intent = new Intent(MainActivity.this,FoodActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Food")
                        .setMessage("Would you like to find nearby restaurants?")
                        .show();

            }
        });

        final CardView bookCard = (CardView)findViewById(R.id.flightBook);
        bookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Book Ticket")
                        .setMessage("Would you like to book a flight ticket?")
                        .show();

            }
        });

        final CardView gameCard = (CardView)findViewById(R.id.flightGame);
        gameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                if(!flag)
                                {
                                    flag = true;
                                    Intent intent = new Intent(MainActivity.this, FlappyBirdGame.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    flag = false;
                                    Intent intent = new Intent(MainActivity.this, TwoGameActivity.class);
                                    startActivity(intent);
                                }

                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Games")
                        .setMessage("How about playing some games?")
                        .show();


            }
        });

        final CardView meditateCard = (CardView)findViewById(R.id.flightMeditate);
        meditateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Intent intent = new Intent(MainActivity.this,MeditationActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Meditate")
                        .setMessage("Stressed or tired, meditation should help")
                        .show();

            }
        });

        final CardView travelCard = (CardView)findViewById(R.id.flightPlaces);
        travelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                getSupportForPlaces();
                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Travel")
                        .setMessage("How about watching some of the best places to travel?")
                        .show();

            }
        });

        final FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fabx);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                makeCall();
                            }
                        })
                        .setNegativeButton("No", null)
                        .setTitle("Need help")
                        .setMessage("Would you like to call our support team")
                        .show();

            }
        });









    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PHONE_CALL: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                }
                else
                {

                }
                return;
            }
        }
    }







    private void getSupportForPlaces()
    {
        String[] place_message={"I think Kashmir is a great place","I strongly feel London is a must visit","How about Paris? You'd definitely love it","The himalayas in India seems like an epic destination","I would definitely travel to St Petersburg in Russia someday","How about Rome in Italy, seems like a classic destination to me","I think Thailand is a cool place","Rajasthan in India seems like an ideal place for a getaway","How about Barcelona, it's a perfect destination","I personally feel you'd like Budapest, Hungary"};
        String[] place_url = {"9l7wiqEGrfc","PtWeqZsuzpE","x0Pa8aIqmNI","ZQnDpCjtSfE","LAxf-05NTRY","h9fHP9IvbiI","HL69WXRQrO0","CES7WqrYuSE","L_bgTJkFk3k","B_Hfmp-z7AE"};

        int x = Util.getRandom(10);



        Intent intent = YouTubeStandalonePlayer.createVideoIntent(MainActivity.this, DeveloperKey.DEVELOPER_KEY, place_url[x]);
        Bundle extras = new Bundle();
        extras.putString("YOUTUBE_VIDEO", place_url[x]);
        intent.putExtras(extras);
        startActivity(intent);


    }

    private void makeCall()
    {
        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"));

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
            }
            else
            {
                startActivity(intent);
            }
        }
        else
        {
            startActivity(intent);
        }

    }
}
