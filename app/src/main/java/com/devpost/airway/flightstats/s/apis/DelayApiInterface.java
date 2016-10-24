package com.devpost.airway.flightstats.s.apis;


import com.devpost.airway.flightstats.s.delay.DelayPojo;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface DelayApiInterface
{
    @GET
    Call<DelayPojo> getDelayValues(@Url String url, @Query("appId") String appId, @Query("appKey") String key, @Query("classification") int classification, @Query("score") int score);
}
