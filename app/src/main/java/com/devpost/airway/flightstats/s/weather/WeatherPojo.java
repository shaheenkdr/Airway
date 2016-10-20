package com.devpost.airway.flightstats.s.weather;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherPojo {

    @SerializedName("request")
    @Expose
    private Request request;
    @SerializedName("metar")
    @Expose
    private Metar metar;
    @SerializedName("taf")
    @Expose
    private Taf taf;
    @SerializedName("zoneForecast")
    @Expose
    private ZoneForecast zoneForecast;
    @SerializedName("appendix")
    @Expose
    private Appendix appendix;

    /**
     *
     * @return
     * The request
     */
    public Request getRequest() {
        return request;
    }

    /**
     *
     * @param request
     * The request
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     *
     * @return
     * The metar
     */
    public Metar getMetar() {
        return metar;
    }

    /**
     *
     * @param metar
     * The metar
     */
    public void setMetar(Metar metar) {
        this.metar = metar;
    }

    /**
     *
     * @return
     * The taf
     */
    public Taf getTaf() {
        return taf;
    }

    /**
     *
     * @param taf
     * The taf
     */
    public void setTaf(Taf taf) {
        this.taf = taf;
    }

    /**
     *
     * @return
     * The zoneForecast
     */
    public ZoneForecast getZoneForecast() {
        return zoneForecast;
    }

    /**
     *
     * @param zoneForecast
     * The zoneForecast
     */
    public void setZoneForecast(ZoneForecast zoneForecast) {
        this.zoneForecast = zoneForecast;
    }

    /**
     *
     * @return
     * The appendix
     */
    public Appendix getAppendix() {
        return appendix;
    }

    /**
     *
     * @param appendix
     * The appendix
     */
    public void setAppendix(Appendix appendix) {
        this.appendix = appendix;
    }

}