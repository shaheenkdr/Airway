package com.devpost.airway.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.SignUpEvent;
import com.devpost.airway.R;
import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.FadeInAnimation;
import com.easyandroidanimations.library.FadeOutAnimation;

import io.fabric.sdk.android.Fabric;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity
{
    private Timer timer = new Timer();
    private final long DELAY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        final SharedPreferences pref = getSharedPreferences("ActivitySession", Context.MODE_PRIVATE);
        final String Test ="";
        String abc = pref.getString("HASH","");
        if(!abc.equals(Test))
        {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();

        }

        final TextView text = (TextView)findViewById(R.id.HiText);
        TextView textDesc = (TextView)findViewById(R.id.descTextSplash);
        final EditText ed1 = (EditText)findViewById(R.id.textName);
        final Button b1 = (Button)findViewById(R.id.buttonSave);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("HASH","DO I REALLY LOOK LIKE A GUY WITH A PLAN");
                editor.apply();
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                Bundle extras = new Bundle();
                extras.putString("NAME",ed1.getText().toString());
                Answers.getInstance().logSignUp(new SignUpEvent()
                        .putMethod("AB")
                        .putSuccess(true)
                        .putCustomAttribute("NAME", ed1.getText().toString()));
                startActivity(intent);
                finish();
            }
        });
        Typeface face = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Regular.ttf");
        text.setTypeface(face);
        textDesc.setTypeface(face);
        text.setText("Hi");
        textDesc.setText("Tell us your Name");


        ed1.setVisibility(View.VISIBLE);


        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void onTextChanged(final CharSequence s, int start, int before,
                                      int count) {
                if(timer != null)
                    timer.cancel();
            }
            @Override
            public void afterTextChanged(final Editable s)
            {
                //avoid triggering event when text is too short
                if (s.length() >= 3) {

                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run()
                        {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run()
                                {
                                    b1.setVisibility(View.VISIBLE);

                                }
                            });
                        }

                    }, DELAY);
                }
            }
        });


    }
}
