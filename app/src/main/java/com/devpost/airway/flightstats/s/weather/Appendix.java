package com.devpost.airway.flightstats.s.weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appendix {

    @SerializedName("airports")
    @Expose
    private List<Airport_> airports = new ArrayList<Airport_>();

    /**
     *
     * @return
     * The airports
     */
    public List<Airport_> getAirports() {
        return airports;
    }

    /**
     *
     * @param airports
     * The airports
     */
    public void setAirports(List<Airport_> airports) {
        this.airports = airports;
    }

}