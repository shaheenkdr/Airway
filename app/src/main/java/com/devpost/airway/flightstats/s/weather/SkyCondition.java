package com.devpost.airway.flightstats.s.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyCondition {

    @SerializedName("coverage")
    @Expose
    private String coverage;

    /**
     *
     * @return
     * The coverage
     */
    public String getCoverage() {
        return coverage;
    }

    /**
     *
     * @param coverage
     * The coverage
     */
    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

}