
package com.devpost.airway.flightstats.s.flight_tracker.departure;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IncludeFlightPlan {

    @SerializedName("requested")
    @Expose
    private String requested;
    @SerializedName("interpreted")
    @Expose
    private Boolean interpreted;

    /**
     * 
     * @return
     *     The requested
     */
    public String getRequested() {
        return requested;
    }

    /**
     * 
     * @param requested
     *     The requested
     */
    public void setRequested(String requested) {
        this.requested = requested;
    }

    /**
     * 
     * @return
     *     The interpreted
     */
    public Boolean getInterpreted() {
        return interpreted;
    }

    /**
     * 
     * @param interpreted
     *     The interpreted
     */
    public void setInterpreted(Boolean interpreted) {
        this.interpreted = interpreted;
    }

}
