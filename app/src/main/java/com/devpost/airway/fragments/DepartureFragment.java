package com.devpost.airway.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.devpost.airway.R;
import com.devpost.airway.adapter.ArrivalAdapterSupport;
import com.devpost.airway.adapter.FlightArrivalAdapter;
import com.devpost.airway.api.ApiClient;
import com.devpost.airway.bus.FragBus;
import com.devpost.airway.flightstats.s.apis.DepartureApiInterface;
import com.devpost.airway.flightstats.s.flight_tracker.departure.DepartureTrackerPojo;
import com.devpost.airway.flightstats.s.flight_tracker.departure.FlightTrack;
import com.devpost.airway.utility.Util;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartureFragment extends Fragment
{
    private static final String URL_DEPARTURE = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/airport/tracks/";
    private static final String CARRIER_ID = "AB";
    private static final boolean FLIGHT_PLAN = false;
    private static final int MAX_POSITION = 2;
    private static final int MAX_FLIGHTS = 5;
    private RecyclerView departureView;
    private FlightArrivalAdapter frAdapter;
    private List<ArrivalAdapterSupport> adapter_data;

    private static ProgressDialog pr;
    private static int map_val;
    private static HashMap<Integer,String> map;
    private boolean isViewShown = false;

    static
    {
        map_val = -1;
        map = new HashMap<>();
        map.put(0,"ATL");
        map.put(1,"ORD");
        map.put(2,"LAX");
        map.put(3,"DFW");
        map.put(4,"DEN");
        map.put(5,"JFK");
        map.put(6,"SFO");
        map.put(7,"CLT");
        map.put(8,"LAS");
        map.put(9,"PHX");
        map.put(10,"MIA");
        map.put(11,"MCO");
        map.put(12,"EWR");
        map.put(13,"SEA");
        map.put(14,"DTW");
        map.put(15,"PHL");
        map.put(16,"LGA");
        map.put(17,"FRA");
        map.put(18,"MUC");
        map.put(19,"DUS");
        map.put(20,"TXL");
        map.put(21,"HAM");
        map.put(22,"STR");
        map.put(23,"CGN");
        map.put(24,"SXF");
        map.put(25,"HAJ");
        map.put(26,"NUE");
        map.put(27,"BRE");
        map.put(28,"HHN");
        map.put(29,"DTM");
        map.put(30,"NRN");
        map.put(31,"DRS");
        map.put(32,"PAD");
        map.put(33,"RLG");
        map.put(34,"ERF");
    }


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
        pr = new ProgressDialog(getContext());

        if (isViewShown) {
            fetchData();
        }

        return rootView;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getView() != null) {
            isViewShown = true;
            fetchData();
        } else {
            isViewShown = false;
        }
    }


    private void fetchData()
    {
        try{new MaterialDialog.Builder(getContext())
                .title(R.string.title_dialog)
                .items(R.array.airport_list)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text)
                    {
                        Log.e("<MAP>",map.get(which));
                        map_val = which;
                        String temp = URL_DEPARTURE+map.get(which)+"/dep";
                        getDepartureValues(temp);
                        pr.show();
                        return true;
                    }
                })
                .positiveText(R.string.choose)
                .show();}
        catch(Exception e){e.printStackTrace();}

    }


    private void getDepartureValues(final String DEP_URL)
    {
        DepartureApiInterface apiService =
                ApiClient.getClient().create(DepartureApiInterface.class);

        Call<DepartureTrackerPojo> call = apiService.getDepartureValues(DEP_URL, Util.getAppId(),Util.getAppKey(),CARRIER_ID,FLIGHT_PLAN,MAX_POSITION,MAX_FLIGHTS);
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
                        adapter_data.add(new ArrivalAdapterSupport(t.getPositions().get(0).getLat(),t.getPositions().get(0).getLon(),t.getDepartureDate().getDateLocal(),t.getDepartureAirportFsCode(),t.getArrivalAirportFsCode(),t.getFlightNumber(),t.getPositions().get(0).getSpeedMph(),t.getPositions().get(0).getAltitudeFt()));
                        frAdapter.notifyDataSetChanged();
                    }
                    pr.dismiss();

                    try {
                        if (track.size() == 0) {
                            Snackbar.make(getView(), "No Airberlin flights arriving at this time :/", Snackbar.LENGTH_LONG).show();

                        } else {
                            Snackbar.make(getView(), "Click on a flight to track its position", Snackbar.LENGTH_LONG).show();

                        }
                    }
                    catch (Exception e){}

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
