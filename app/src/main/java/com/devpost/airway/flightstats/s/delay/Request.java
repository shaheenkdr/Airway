package com.devpost.airway.flightstats.s.delay;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("airportCodes")
    @Expose
    private List<AirportCode> airportCodes = new ArrayList<AirportCode>();
    @SerializedName("codeType")
    @Expose
    private CodeType codeType;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("classification")
    @Expose
    private Classification classification;
    @SerializedName("score")
    @Expose
    private Score score;

    /**
     *
     * @return
     * The airportCodes
     */
    public List<AirportCode> getAirportCodes() {
        return airportCodes;
    }

    /**
     *
     * @param airportCodes
     * The airportCodes
     */
    public void setAirportCodes(List<AirportCode> airportCodes) {
        this.airportCodes = airportCodes;
    }

    /**
     *
     * @return
     * The codeType
     */
    public CodeType getCodeType() {
        return codeType;
    }

    /**
     *
     * @param codeType
     * The codeType
     */
    public void setCodeType(CodeType codeType) {
        this.codeType = codeType;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The classification
     */
    public Classification getClassification() {
        return classification;
    }

    /**
     *
     * @param classification
     * The classification
     */
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    /**
     *
     * @return
     * The score
     */
    public Score getScore() {
        return score;
    }

    /**
     *
     * @param score
     * The score
     */
    public void setScore(Score score) {
        this.score = score;
    }

}