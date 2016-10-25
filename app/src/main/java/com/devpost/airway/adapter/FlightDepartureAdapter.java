package com.devpost.airway.adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devpost.airway.R;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FlightDepartureAdapter extends RecyclerView.Adapter<FlightDepartureAdapter.DeparturesViewHolder>
{



    DataHolder d1 = new DataHolder();




    public  class DeparturesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView flightNo;
        TextView flightDate;
        TextView flightRoute;




        DeparturesViewHolder(View itemView) {
            super(itemView);

            flightNo = (TextView)itemView.findViewById(R.id.flightCodeDep);
            flightDate = (TextView)itemView.findViewById(R.id.arrivalDateDep);
            flightRoute =(TextView)itemView.findViewById(R.id.airport_to_airport_Dep);

            Typeface face= Typeface.createFromAsset(itemView.getContext().getAssets(), "Fonts/Roboto-Regular.ttf");
            flightNo.setTypeface(face);
            flightDate.setTypeface(face);
            flightRoute.setTypeface(face);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view)
        {



        }
    }

    private class DataHolder
    {
        List<ArrivalAdapterSupport> departure_records;

    }



    public FlightDepartureAdapter(List<ArrivalAdapterSupport> departure_records){
        this.d1.departure_records = departure_records;
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public DeparturesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.departure_card, viewGroup, false);
        DeparturesViewHolder pvh = new DeparturesViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(DeparturesViewHolder departuresViewHolder, int i)
    {

        String output;
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date result = format.parse(d1.departure_records.get(i).getDate());
            Calendar cal = Calendar.getInstance();
            cal.setTime(result);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            output = day+" "+getMonthForInt(month)+" "+year;
            departuresViewHolder.flightDate.setText(output);
            Log.w("THE DATE IS:",""+output);
        }
        catch (Exception e){e.printStackTrace();}

        departuresViewHolder.flightRoute.setText(d1.departure_records.get(i).getRouteA()+" - "+d1.departure_records.get(i).getRouteB());
        departuresViewHolder.flightNo.setText("Flight No: "+d1.departure_records.get(i).getFlightNo());

    }

    @Override
    public int getItemCount()
    {

        if(d1.departure_records!=null)
        {
            return d1.departure_records.size();
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
