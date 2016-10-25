package com.devpost.airway.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.devpost.airway.R;
import com.devpost.airway.adapter.ArrivalAdapterSupport;
import com.devpost.airway.adapter.FlightArrivalAdapter;
import com.devpost.airway.api.ApiClient;
import com.devpost.airway.flightstats.s.apis.ArrivalApiInterface;
import com.devpost.airway.flightstats.s.flight_tracker.arrival.ArrivalTrackerPojo;
import com.devpost.airway.flightstats.s.flight_tracker.arrival.FlightTrack;
import com.devpost.airway.flightstats.s.flight_tracker.arrival.Position;
import com.devpost.airway.utility.Util;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArrivalFragment extends Fragment
{
    private static final String URL_ARRIVAL = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/airport/tracks/TXL/arr";
    private static final String CARRIER_ID = "AB";
    private static final boolean FLIGHT_PLAN = false;
    private static final int MAX_POSITION = 2;
    private static final int MAX_FLIGHTS = 5;
    private RecyclerView arrivalView;
    private FlightArrivalAdapter frAdapter;
    private List<ArrivalAdapterSupport> adapter_data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.arrival_fragment, container, false);
        arrivalView = (RecyclerView)rootView.findViewById(R.id.rv_arrival);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        arrivalView.setLayoutManager(llm);
        adapter_data = new ArrayList<>();
        frAdapter = new FlightArrivalAdapter(adapter_data);
        arrivalView.setAdapter(frAdapter);
        getArrivalValues();
        return rootView;
    }

    private void getArrivalValues()
    {
        ArrivalApiInterface apiService =
                ApiClient.getClient().create(ArrivalApiInterface.class);

        Call<ArrivalTrackerPojo> call = apiService.getArrivalValues(URL_ARRIVAL, Util.getAppId(),Util.getAppKey(),CARRIER_ID,FLIGHT_PLAN,MAX_POSITION,MAX_FLIGHTS);
        call.enqueue(new Callback<ArrivalTrackerPojo>()
        {
            @Override
            public void onResponse(Call<ArrivalTrackerPojo>call, Response<ArrivalTrackerPojo> response)
            {
                String x = call.request().url().toString();
                if (response.isSuccessful())
                {
                    // Do your success stuff...
                    List<FlightTrack> track = response.body().getFlightTracks();

                    for(FlightTrack t:track)
                    {
                        adapter_data.add(new ArrivalAdapterSupport(t.getPositions().get(0).getLat(),t.getPositions().get(0).getLon(),t.getDepartureDate().getDateLocal(),t.getDepartureAirportFsCode(),t.getArrivalAirportFsCode(),t.getFlightNumber()));
                        frAdapter.notifyDataSetChanged();
                    }
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(getActivity(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrivalTrackerPojo> call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE", t.toString());
            }
        });
    }


}
