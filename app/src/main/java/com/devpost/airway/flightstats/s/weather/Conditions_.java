package com.devpost.airway.flightstats.s.weather;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Conditions_ {

    @SerializedName("wind")
    @Expose
    private Wind_ wind;
    @SerializedName("visibility")
    @Expose
    private Visibility_ visibility;
    @SerializedName("weatherConditions")
    @Expose
    private List<Object> weatherConditions = new ArrayList<Object>();
    @SerializedName("skyConditions")
    @Expose
    private List<SkyCondition_> skyConditions = new ArrayList<SkyCondition_>();

    /**
     *
     * @return
     * The wind
     */
    public Wind_ getWind() {
        return wind;
    }

    /**
     *
     * @param wind
     * The wind
     */
    public void setWind(Wind_ wind) {
        this.wind = wind;
    }

    /**
     *
     * @return
     * The visibility
     */
    public Visibility_ getVisibility() {
        return visibility;
    }

    /**
     *
     * @param visibility
     * The visibility
     */
    public void setVisibility(Visibility_ visibility) {
        this.visibility = visibility;
    }

    /**
     *
     * @return
     * The weatherConditions
     */
    public List<Object> getWeatherConditions() {
        return weatherConditions;
    }

    /**
     *
     * @param weatherConditions
     * The weatherConditions
     */
    public void setWeatherConditions(List<Object> weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    /**
     *
     * @return
     * The skyConditions
     */
    public List<SkyCondition_> getSkyConditions() {
        return skyConditions;
    }

    /**
     *
     * @param skyConditions
     * The skyConditions
     */
    public void setSkyConditions(List<SkyCondition_> skyConditions) {
        this.skyConditions = skyConditions;
    }

}