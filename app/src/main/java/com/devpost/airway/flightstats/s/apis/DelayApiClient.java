package com.devpost.airway.flightstats.s.apis;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DelayApiClient
{
    private static final String BASE_URL = "https://api.flightstats.com/flex/delayindex/rest/v1/json/airports/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient()
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
