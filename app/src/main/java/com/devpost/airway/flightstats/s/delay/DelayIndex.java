package com.devpost.airway.flightstats.s.delay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DelayIndex {

    @SerializedName("airport")
    @Expose
    private Airport airport;
    @SerializedName("rawScore")
    @Expose
    private Double rawScore;
    @SerializedName("normalizedScore")
    @Expose
    private Double normalizedScore;
    @SerializedName("dateStart")
    @Expose
    private String dateStart;
    @SerializedName("dateEnd")
    @Expose
    private String dateEnd;
    @SerializedName("flights")
    @Expose
    private Integer flights;
    @SerializedName("observations")
    @Expose
    private Integer observations;
    @SerializedName("canceled")
    @Expose
    private Integer canceled;
    @SerializedName("onTime")
    @Expose
    private Integer onTime;
    @SerializedName("delayed15")
    @Expose
    private Integer delayed15;
    @SerializedName("delayed30")
    @Expose
    private Integer delayed30;
    @SerializedName("delayed45")
    @Expose
    private Integer delayed45;
    @SerializedName("delta")
    @Expose
    private Double delta;

    /**
     *
     * @return
     * The airport
     */
    public Airport getAirport() {
        return airport;
    }

    /**
     *
     * @param airport
     * The airport
     */
    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    /**
     *
     * @return
     * The rawScore
     */
    public Double getRawScore() {
        return rawScore;
    }

    /**
     *
     * @param rawScore
     * The rawScore
     */
    public void setRawScore(Double rawScore) {
        this.rawScore = rawScore;
    }

    /**
     *
     * @return
     * The normalizedScore
     */
    public Double getNormalizedScore() {
        return normalizedScore;
    }

    /**
     *
     * @param normalizedScore
     * The normalizedScore
     */
    public void setNormalizedScore(Double normalizedScore) {
        this.normalizedScore = normalizedScore;
    }

    /**
     *
     * @return
     * The dateStart
     */
    public String getDateStart() {
        return dateStart;
    }

    /**
     *
     * @param dateStart
     * The dateStart
     */
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    /**
     *
     * @return
     * The dateEnd
     */
    public String getDateEnd() {
        return dateEnd;
    }

    /**
     *
     * @param dateEnd
     * The dateEnd
     */
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     *
     * @return
     * The flights
     */
    public Integer getFlights() {
        return flights;
    }

    /**
     *
     * @param flights
     * The flights
     */
    public void setFlights(Integer flights) {
        this.flights = flights;
    }

    /**
     *
     * @return
     * The observations
     */
    public Integer getObservations() {
        return observations;
    }

    /**
     *
     * @param observations
     * The observations
     */
    public void setObservations(Integer observations) {
        this.observations = observations;
    }

    /**
     *
     * @return
     * The canceled
     */
    public Integer getCanceled() {
        return canceled;
    }

    /**
     *
     * @param canceled
     * The canceled
     */
    public void setCanceled(Integer canceled) {
        this.canceled = canceled;
    }

    /**
     *
     * @return
     * The onTime
     */
    public Integer getOnTime() {
        return onTime;
    }

    /**
     *
     * @param onTime
     * The onTime
     */
    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    /**
     *
     * @return
     * The delayed15
     */
    public Integer getDelayed15() {
        return delayed15;
    }

    /**
     *
     * @param delayed15
     * The delayed15
     */
    public void setDelayed15(Integer delayed15) {
        this.delayed15 = delayed15;
    }

    /**
     *
     * @return
     * The delayed30
     */
    public Integer getDelayed30() {
        return delayed30;
    }

    /**
     *
     * @param delayed30
     * The delayed30
     */
    public void setDelayed30(Integer delayed30) {
        this.delayed30 = delayed30;
    }

    /**
     *
     * @return
     * The delayed45
     */
    public Integer getDelayed45() {
        return delayed45;
    }

    /**
     *
     * @param delayed45
     * The delayed45
     */
    public void setDelayed45(Integer delayed45) {
        this.delayed45 = delayed45;
    }

    /**
     *
     * @return
     * The delta
     */
    public Double getDelta() {
        return delta;
    }

    /**
     *
     * @param delta
     * The delta
     */
    public void setDelta(Double delta) {
        this.delta = delta;
    }

}