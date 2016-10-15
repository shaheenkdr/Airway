package com.devpost.airway.api;


import com.devpost.airway.pojo.LuisPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("application")
    Call<LuisPojo> getValues(@Query("id") String apiKey, @Query("subscription-key") String key, @Query("q") String q);


}