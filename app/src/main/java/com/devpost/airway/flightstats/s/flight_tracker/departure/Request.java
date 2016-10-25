
package com.devpost.airway.flightstats.s.flight_tracker.departure;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("airport")
    @Expose
    private Airport airport;
    @SerializedName("carrier")
    @Expose
    private Carrier carrier;
    @SerializedName("includeFlightPlan")
    @Expose
    private IncludeFlightPlan includeFlightPlan;
    @SerializedName("maxPositions")
    @Expose
    private MaxPositions maxPositions;
    @SerializedName("maxPositionAgeMinutes")
    @Expose
    private MaxPositionAgeMinutes maxPositionAgeMinutes;
    @SerializedName("codeType")
    @Expose
    private CodeType codeType;
    @SerializedName("maxFlights")
    @Expose
    private MaxFlights maxFlights;
    @SerializedName("extendedOptions")
    @Expose
    private ExtendedOptions extendedOptions;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The airport
     */
    public Airport getAirport() {
        return airport;
    }

    /**
     * 
     * @param airport
     *     The airport
     */
    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    /**
     * 
     * @return
     *     The carrier
     */
    public Carrier getCarrier() {
        return carrier;
    }

    /**
     * 
     * @param carrier
     *     The carrier
     */
    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    /**
     * 
     * @return
     *     The includeFlightPlan
     */
    public IncludeFlightPlan getIncludeFlightPlan() {
        return includeFlightPlan;
    }

    /**
     * 
     * @param includeFlightPlan
     *     The includeFlightPlan
     */
    public void setIncludeFlightPlan(IncludeFlightPlan includeFlightPlan) {
        this.includeFlightPlan = includeFlightPlan;
    }

    /**
     * 
     * @return
     *     The maxPositions
     */
    public MaxPositions getMaxPositions() {
        return maxPositions;
    }

    /**
     * 
     * @param maxPositions
     *     The maxPositions
     */
    public void setMaxPositions(MaxPositions maxPositions) {
        this.maxPositions = maxPositions;
    }

    /**
     * 
     * @return
     *     The maxPositionAgeMinutes
     */
    public MaxPositionAgeMinutes getMaxPositionAgeMinutes() {
        return maxPositionAgeMinutes;
    }

    /**
     * 
     * @param maxPositionAgeMinutes
     *     The maxPositionAgeMinutes
     */
    public void setMaxPositionAgeMinutes(MaxPositionAgeMinutes maxPositionAgeMinutes) {
        this.maxPositionAgeMinutes = maxPositionAgeMinutes;
    }

    /**
     * 
     * @return
     *     The codeType
     */
    public CodeType getCodeType() {
        return codeType;
    }

    /**
     * 
     * @param codeType
     *     The codeType
     */
    public void setCodeType(CodeType codeType) {
        this.codeType = codeType;
    }

    /**
     * 
     * @return
     *     The maxFlights
     */
    public MaxFlights getMaxFlights() {
        return maxFlights;
    }

    /**
     * 
     * @param maxFlights
     *     The maxFlights
     */
    public void setMaxFlights(MaxFlights maxFlights) {
        this.maxFlights = maxFlights;
    }

    /**
     * 
     * @return
     *     The extendedOptions
     */
    public ExtendedOptions getExtendedOptions() {
        return extendedOptions;
    }

    /**
     * 
     * @param extendedOptions
     *     The extendedOptions
     */
    public void setExtendedOptions(ExtendedOptions extendedOptions) {
        this.extendedOptions = extendedOptions;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
