package com.devpost.airway.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.devpost.airway.R;
import com.devpost.airway.adapter.CustomPlacesAdapter;
import com.devpost.airway.api.ApiClient;
import com.devpost.airway.api.ApiClientPlaces;
import com.devpost.airway.api.ApiInterface;
import com.devpost.airway.api.ApiInterfacePlaces;
import com.devpost.airway.bus.LuisResponseBus;
import com.devpost.airway.places_api.Geometry;
import com.devpost.airway.places_api.Location;
import com.devpost.airway.places_api.PlacesPojo;
import com.devpost.airway.places_api.Result;
import com.devpost.airway.pojo.IntentX;
import com.devpost.airway.pojo.LuisPojo;
import com.devpost.airway.utility.LatLong;
import com.devpost.airway.utility.Util;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;



import org.greenrobot.eventbus.EventBus;

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
        setContentView(R.layout.activity_food);


        doGetRequest("restaurants in los angeles airport");
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(-33.867, 151.206);

        //map.setMyLocationEnabled(false);
        for(LatLong x:list_location)
        {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(x.getLat(),x.getLng()), 12));
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
