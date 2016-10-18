package com.devpost.airway.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.devpost.airway.R;
import com.devpost.airway.api.ApiClient;
import com.devpost.airway.api.ApiClientPlaces;
import com.devpost.airway.api.ApiInterface;
import com.devpost.airway.api.ApiInterfacePlaces;
import com.devpost.airway.bus.LuisResponseBus;
import com.devpost.airway.places_api.PlacesPojo;
import com.devpost.airway.pojo.IntentX;
import com.devpost.airway.pojo.LuisPojo;
import com.devpost.airway.utility.Util;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
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
                    double temp = 0;
                    StringBuilder val = new StringBuilder();
                    Log.e("Thenga",""+response.body().toString());


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
