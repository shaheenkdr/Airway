package com.devpost.airway.flightstats.s.weather;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CodeType {

    @SerializedName("requested")
    @Expose
    private String requested;
    @SerializedName("interpreted")
    @Expose
    private String interpreted;

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
    public String getInterpreted() {
        return interpreted;
    }

    /**
     *
     * @param interpreted
     * The interpreted
     */
    public void setInterpreted(String interpreted) {
        this.interpreted = interpreted;
    }

}