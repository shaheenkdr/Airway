package com.devpost.airway.flightstats.s.delay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {

    @SerializedName("requested")
    @Expose
    private String requested;
    @SerializedName("interpreted")
    @Expose
    private Double interpreted;

    /**
     *
     * @return
     * The requested
     */
    public String getRequested() {
        return requested;
    }

    /**
     *
     * @param requested
     * The requested
     */
    public void setRequested(String requested) {
        this.requested = requested;
    }

    /**
     *
     * @return
     * The interpreted
     */
    public Double getInterpreted() {
        return interpreted;
    }

    /**
     *
     * @param interpreted
     * The interpreted
     */
    public void setInterpreted(Double interpreted) {
        this.interpreted = interpreted;
    }

}