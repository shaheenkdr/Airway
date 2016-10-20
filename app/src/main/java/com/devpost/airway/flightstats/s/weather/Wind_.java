package com.devpost.airway.flightstats.s.weather;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind_ {

    @SerializedName("directionIsVariable")
    @Expose
    private Boolean directionIsVariable;
    @SerializedName("speedKnots")
    @Expose
    private String speedKnots;

    /**
     *
     * @return
     * The directionIsVariable
     */
    public Boolean getDirectionIsVariable() {
        return directionIsVariable;
    }

    /**
     *
     * @param directionIsVariable
     * The directionIsVariable
     */
    public void setDirectionIsVariable(Boolean directionIsVariable) {
        this.directionIsVariable = directionIsVariable;
    }

    /**
     *
     * @return
     * The speedKnots
     */
    public String getSpeedKnots() {
        return speedKnots;
    }

    /**
     *
     * @param speedKnots
     * The speedKnots
     */
    public void setSpeedKnots(String speedKnots) {
        this.speedKnots = speedKnots;
    }

}