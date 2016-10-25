package com.devpost.airway.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.devpost.airway.R;
import com.devpost.airway.adapter.TabsPagerAdapter;
import com.devpost.airway.api.ApiClient;
import com.devpost.airway.flightstats.s.apis.ArrivalApiInterface;
import com.devpost.airway.flightstats.s.apis.DepartureApiInterface;
import com.devpost.airway.flightstats.s.apis.WeatherApiInterface;
import com.devpost.airway.flightstats.s.flight_tracker.arrival.ArrivalTrackerPojo;
import com.devpost.airway.flightstats.s.flight_tracker.arrival.FlightTrack;
import com.devpost.airway.flightstats.s.flight_tracker.arrival.Position;

import com.devpost.airway.flightstats.s.flight_tracker.departure.DepartureTrackerPojo;
import com.devpost.airway.flightstats.s.weather.WeatherPojo;
import com.devpost.airway.utility.Util;

import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlightTrackerActivity extends AppCompatActivity
{
    private static final String URL_ARRIVAL = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/airport/tracks/TXL/arr";
    private static final String URL_DEPARTURE = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/airport/tracks/TXL/dep";
    private static final String CARRIER_ID = "AB";
    private static final boolean FLIGHT_PLAN = false;
    private static final int MAX_POSITION = 2;
    private static final int MAX_FLIGHTS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();

        setContentView(R.layout.activity_flight_tracker);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Arrival"));
        tabLayout.addTab(tabLayout.newTab().setText("Departure"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final TabsPagerAdapter adapter = new TabsPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //getArrivalValues();
    }



}
