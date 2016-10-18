package com.devpost.airway.api;


import com.devpost.airway.places_api.PlacesPojo;
import com.devpost.airway.pojo.LuisPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterfacePlaces
{
    @GET("json")
    Call<PlacesPojo> getValues(@Query("query") String placeToSearch, @Query("key") String apiKey);


}
