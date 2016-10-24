package com.devpost.airway.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.devpost.airway.R;
import com.devpost.airway.api.ApiClient;
import com.devpost.airway.api.ApiInterface;
import com.devpost.airway.bus.LuisResponseBus;
import com.devpost.airway.flightstats.s.apis.WeatherApiInterface;
import com.devpost.airway.flightstats.s.weather.WeatherPojo;
import com.devpost.airway.pojo.IntentX;
import com.devpost.airway.pojo.LuisPojo;
import com.devpost.airway.utility.Util;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity
{
    private static final String ID = "https://api.flightstats.com/flex/weather/rest/v1/json/all/COK";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        getWeather();
    }

    private void getWeather()
    {
        WeatherApiInterface apiService =
                ApiClient.getClient().create(WeatherApiInterface.class);

        Call<WeatherPojo> call = apiService.getValues(ID, Util.getAppId(),Util.getAppKey(),Util.getCodeType());
        call.enqueue(new Callback<WeatherPojo>()
        {
            @Override
            public void onResponse(Call<WeatherPojo>call, Response<WeatherPojo> response)
            {
                String x = call.request().url().toString();
                if (response.isSuccessful())
                {
                    // Do your success stuff...
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(WeatherActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(WeatherActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherPojo> call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE", t.toString());
            }
        });

    }
}
