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
import com.devpost.airway.flightstats.s.apis.DepartureApiInterface;
import com.devpost.airway.flightstats.s.flight_tracker.departure.DepartureTrackerPojo;
import com.devpost.airway.flightstats.s.flight_tracker.departure.FlightTrack;
import com.devpost.airway.utility.Util;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartureFragment extends Fragment
{
    private static final String URL_DEPARTURE = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/airport/tracks/TXL/dep";
    private static final String CARRIER_ID = "AB";
    private static final boolean FLIGHT_PLAN = false;
    private static final int MAX_POSITION = 2;
    private static final int MAX_FLIGHTS = 5;
    private RecyclerView departureView;
    private FlightArrivalAdapter frAdapter;
    private List<ArrivalAdapterSupport> adapter_data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.departure_fragment, container, false);
        departureView = (RecyclerView)rootView.findViewById(R.id.rv_departure);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        departureView.setLayoutManager(llm);
        adapter_data = new ArrayList<>();
        frAdapter = new FlightArrivalAdapter(adapter_data);
        departureView.setAdapter(frAdapter);
        getDepartureValues();
        return rootView;

    }

    private void getDepartureValues()
    {
        DepartureApiInterface apiService =
                ApiClient.getClient().create(DepartureApiInterface.class);

        Call<DepartureTrackerPojo> call = apiService.getDepartureValues(URL_DEPARTURE, Util.getAppId(),Util.getAppKey(),CARRIER_ID,FLIGHT_PLAN,MAX_POSITION,MAX_FLIGHTS);
        call.enqueue(new Callback<DepartureTrackerPojo>()
        {
            @Override
            public void onResponse(Call<DepartureTrackerPojo>call, Response<DepartureTrackerPojo> response)
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
                        Toast.makeText(getContext(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<DepartureTrackerPojo> call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE", t.toString());
            }
        });

    }

}
