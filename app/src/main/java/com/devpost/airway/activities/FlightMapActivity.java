package com.devpost.airway.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.devpost.airway.R;
import com.devpost.airway.utility.LatLong;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class FlightMapActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private LatLng temp;
    private static String name;
    private static String speed;
    private ProgressDialog pr;
    private String altitude;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_flight_map);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#3178ea"));
        }
        pr = new ProgressDialog(FlightMapActivity.this);
        pr.show();


        Bundle extras = getIntent().getExtras();
        altitude = ""+extras.getInt("ALT")+" Ft";
        temp = new LatLng(extras.getDouble("LAT"),extras.getDouble("LON"));
        name = extras.getString("FLIGHT_NAME");
        speed = "Speed:"+extras.getInt("SPEED")+" Mph";


        ImageButton back = (ImageButton)findViewById(R.id.backFlightMap);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView titleText = (TextView)findViewById(R.id.flightTitleText);
        titleText.setText("FLIGHT NO: "+name);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapFlight);
        mapFragment.getMapAsync(FlightMapActivity.this);
    }

    @Override
    public void onMapReady(GoogleMap map)
    {
        String test = speed+",Height:"+altitude;
        final LatLng mapCoordinates = temp;


            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCoordinates, 12));
            map.addMarker(new MarkerOptions()
                    .title("Flight:"+name)
                    .snippet(test)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.plane_icon))
                    .position(mapCoordinates));



        MapStyleOptions style = MapStyleOptions.loadRawResourceStyle(
                this, R.raw.style_json);
        map.setMapStyle(style);
        pr.dismiss();
    }
}
