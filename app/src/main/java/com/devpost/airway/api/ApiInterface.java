package com.devpost.airway.api;


import com.devpost.airway.pojo.LuisPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface
{
    @GET("44e80599-c74c-4bc7-b30e-41730a6adfb2")
    Call<LuisPojo> getValues(@Query("subscription-key") String key, @Query("q") String q);


}