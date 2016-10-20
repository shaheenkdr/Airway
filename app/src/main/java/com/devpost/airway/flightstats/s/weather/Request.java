package com.devpost.airway.flightstats.s.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("airport")
    @Expose
    private Airport airport;
    @SerializedName("codeType")
    @Expose
    private CodeType codeType;

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

}