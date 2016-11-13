package com.devpost.airway.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.devpost.airway.R;
import com.devpost.airway.api.ApiClientPlaces;
import com.devpost.airway.api.ApiInterfacePlaces;
import com.devpost.airway.places_api.PlacesPojo;
import com.devpost.airway.places_api.Result;
import com.devpost.airway.utility.LatLong;
import com.devpost.airway.utility.Util;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodActivity extends AppCompatActivity implements OnMapReadyCallback
{

    private List<LatLong> list_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_food);
        ImageButton im1 = (ImageButton)findViewById(R.id.backFood);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        new MaterialDialog.Builder(FoodActivity.this)
                .title(R.string.title_dialog)
                .items(R.array.airport_list)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text)
                    {
                        TextView textvv = (TextView)findViewById(R.id.foodtext);
                        textvv.setText(text.toString());
                        doGetRequest("restaurants in"+text.toString()+"airport");
                        Log.e("TWOING",text.toString());
                        return true;
                    }
                })
                .positiveText(R.string.choose)
                .show();



    }

    @Override
    public void onMapReady(GoogleMap map) {

        for(LatLong x:list_location)
        {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(x.getLat(),x.getLng()), 15));
            map.addMarker(new MarkerOptions()
                    .title(x.getName())
                    .snippet(x.getAddress())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.dine))
                    .position(new LatLng(x.getLat(),x.getLng())));
        }


        MapStyleOptions style = MapStyleOptions.loadRawResourceStyle(
                this, R.raw.style_json);
        map.setMapStyle(style);
    }

    private  void doGetRequest(final String message)
    {
        ApiInterfacePlaces apiService =
                ApiClientPlaces.getClient().create(ApiInterfacePlaces.class);

        Call<PlacesPojo> call = apiService.getValues(message, Util.getKeyForPlaces());
        call.enqueue(new Callback<PlacesPojo>()
        {
            @Override
            public void onResponse(Call<PlacesPojo>call, Response<PlacesPojo> response)
            {
                try
                {
                    Log.e("TAG",""+response.body().toString());

                    List<Result> response_res = response.body().getResults();
                    list_location = new ArrayList<LatLong>();

                    for(Result x:response_res)
                    {
                        LatLong obj = new LatLong();
                        obj.setAddress(x.getFormattedAddress());
                        obj.setLat(x.getGeometry().getLocation().getLat());
                        obj.setLng(x.getGeometry().getLocation().getLng());
                        obj.setName(x.getName());
                        list_location.add(obj);
                        obj = null;
                    }

                    MapFragment mapFragment = (MapFragment) getFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(FoodActivity.this);



                }
                catch (Exception e)
                {
                    Toast.makeText(FoodActivity.this, "Check data connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PlacesPojo> call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE", t.toString());
            }
        });
    }
}
