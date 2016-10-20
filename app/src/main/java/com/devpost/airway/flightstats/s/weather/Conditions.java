package com.devpost.airway.flightstats.s.weather;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Conditions {

    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("weatherConditions")
    @Expose
    private List<Object> weatherConditions = new ArrayList<Object>();
    @SerializedName("skyConditions")
    @Expose
    private List<SkyCondition> skyConditions = new ArrayList<SkyCondition>();
    @SerializedName("pressureInchesHg")
    @Expose
    private String pressureInchesHg;

    /**
     *
     * @return
     * The wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     *
     * @param wind
     * The wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     *
     * @return
     * The visibility
     */
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     *
     * @param visibility
     * The visibility
     */
    public void setVisibility(Visibility visibility) {
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
    public List<SkyCondition> getSkyConditions() {
        return skyConditions;
    }

    /**
     *
     * @param skyConditions
     * The skyConditions
     */
    public void setSkyConditions(List<SkyCondition> skyConditions) {
        this.skyConditions = skyConditions;
    }

    /**
     *
     * @return
     * The pressureInchesHg
     */
    public String getPressureInchesHg() {
        return pressureInchesHg;
    }

    /**
     *
     * @param pressureInchesHg
     * The pressureInchesHg
     */
    public void setPressureInchesHg(String pressureInchesHg) {
        this.pressureInchesHg = pressureInchesHg;
    }

}