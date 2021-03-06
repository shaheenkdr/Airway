
package com.devpost.airway.flightstats.s.flight_tracker.arrival;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaxPositions {

    @SerializedName("requested")
    @Expose
    private String requested;
    @SerializedName("interpreted")
    @Expose
    private Integer interpreted;

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
    public Integer getInterpreted() {
        return interpreted;
    }

    /**
     * 
     * @param interpreted
     *     The interpreted
     */
    public void setInterpreted(Integer interpreted) {
        this.interpreted = interpreted;
    }

}
