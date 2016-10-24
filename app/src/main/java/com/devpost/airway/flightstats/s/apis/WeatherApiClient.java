package com.devpost.airway.flightstats.s.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiClient {

    private static String BASE_URL = "https://api.flightstats.com/flex/weather/rest/v1/json/all/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient(String val)
    {

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}