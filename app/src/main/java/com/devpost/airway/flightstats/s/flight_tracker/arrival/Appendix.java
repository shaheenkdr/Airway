
package com.devpost.airway.flightstats.s.flight_tracker.arrival;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appendix {

    @SerializedName("airlines")
    @Expose
    private List<Airline> airlines = new ArrayList<Airline>();
    @SerializedName("airports")
    @Expose
    private List<Airport_> airports = new ArrayList<Airport_>();

    /**
     * 
     * @return
     *     The airlines
     */
    public List<Airline> getAirlines() {
        return airlines;
    }

    /**
     * 
     * @param airlines
     *     The airlines
     */
    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    /**
     * 
     * @return
     *     The airports
     */
    public List<Airport_> getAirports() {
        return airports;
    }

    /**
     * 
     * @param airports
     *     The airports
     */
    public void setAirports(List<Airport_> airports) {
        this.airports = airports;
    }

}
