package com.devpost.airway.adapter;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devpost.airway.R;
import com.devpost.airway.activities.FlightMapActivity;
import com.devpost.airway.flightstats.s.flight_tracker.arrival.ArrivalTrackerPojo;
import com.devpost.airway.flightstats.s.flight_tracker.arrival.FlightTrack;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FlightArrivalAdapter extends RecyclerView.Adapter<FlightArrivalAdapter.ArrivalsViewHolder>
{



    DataHolder d1 = new DataHolder();




    public  class ArrivalsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView flightNo;
        TextView flightDate;
        TextView flightRoute;




        ArrivalsViewHolder(View itemView) {
            super(itemView);

            flightNo = (TextView)itemView.findViewById(R.id.flightCode);
            flightDate = (TextView)itemView.findViewById(R.id.arrivalDate);
            flightRoute =(TextView)itemView.findViewById(R.id.airport_to_airport);

            Typeface face= Typeface.createFromAsset(itemView.getContext().getAssets(), "Fonts/Roboto-Regular.ttf");
            flightNo.setTypeface(face);
            flightDate.setTypeface(face);
            flightRoute.setTypeface(face);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view)
        {
            Intent passCoordinates = new Intent(itemView.getContext(), FlightMapActivity.class);
            Bundle extras = new Bundle();
            extras.putString("FLIGHT_NAME",d1.arrival_records.get(getLayoutPosition()).getFlightNo());
            extras.putInt("SPEED",d1.arrival_records.get(getLayoutPosition()).getSpeed());
            extras.putInt("ALT",d1.arrival_records.get(getLayoutPosition()).getHeight());
            extras.putDouble("LAT", d1.arrival_records.get(getLayoutPosition()).getLatitude());
            extras.putDouble("LON", d1.arrival_records.get(getLayoutPosition()).getLongitude());
            passCoordinates.putExtras(extras);
            itemView.getContext().startActivity(passCoordinates);


        }
    }

    private class DataHolder
    {
        List<ArrivalAdapterSupport> arrival_records;

    }



    public FlightArrivalAdapter(List<ArrivalAdapterSupport> arrival_records){
        this.d1.arrival_records = arrival_records;
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public ArrivalsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.arrival_card, viewGroup, false);
        ArrivalsViewHolder pvh = new ArrivalsViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(ArrivalsViewHolder arrivalsViewHolder, int i)
    {

        String output;
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date result = format.parse(d1.arrival_records.get(i).getDate());
            Calendar cal = Calendar.getInstance();
            cal.setTime(result);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            output = day+" "+getMonthForInt(month)+" "+year;
            arrivalsViewHolder.flightDate.setText(output);
            Log.w("THE DATE IS:",""+output);
        }
        catch (Exception e){e.printStackTrace();}

        arrivalsViewHolder.flightRoute.setText(d1.arrival_records.get(i).getRouteA()+" - "+d1.arrival_records.get(i).getRouteB());
        arrivalsViewHolder.flightNo.setText("Flight No: "+d1.arrival_records.get(i).getFlightNo());

    }

    @Override
    public int getItemCount()
    {

        if(d1.arrival_records!=null)
        {
            return d1.arrival_records.size();
        }
        else
        {
            return 0;
        }
    }

    private static  String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }

}
