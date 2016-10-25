package com.devpost.airway.flightstats.s.apis;

import com.devpost.airway.flightstats.s.delay.DelayPojo;
import com.devpost.airway.flightstats.s.flight_tracker.arrival.ArrivalTrackerPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface ArrivalApiInterface
{
    @GET
    Call<ArrivalTrackerPojo> getArrivalValues(@Url String url, @Query("appId") String appId, @Query("appKey") String key, @Query("carrier") String carrier, @Query("includeFlightPlan") boolean flight_plan, @Query("maxPositions") int position, @Query("maxFlights") int max_flight);
}
