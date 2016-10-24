package com.devpost.airway.flightstats.s.apis;

import com.devpost.airway.flightstats.s.weather.WeatherPojo;
import com.devpost.airway.pojo.LuisPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface WeatherApiInterface
{
    @GET
    Call<WeatherPojo> getValues(@Url String url, @Query("appId") String appId, @Query("appKey") String key, @Query("codeType") String code);
}
