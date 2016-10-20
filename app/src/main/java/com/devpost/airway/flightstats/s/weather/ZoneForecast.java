package com.devpost.airway.flightstats.s.weather;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZoneForecast {

    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("general")
    @Expose
    private String general;
    @SerializedName("zones")
    @Expose
    private List<String> zones = new ArrayList<String>();
    @SerializedName("reportTime")
    @Expose
    private String reportTime;
    @SerializedName("cities")
    @Expose
    private List<String> cities = new ArrayList<String>();
    @SerializedName("zoneNames")
    @Expose
    private List<String> zoneNames = new ArrayList<String>();
    @SerializedName("dayForecasts")
    @Expose
    private List<DayForecast> dayForecasts = new ArrayList<DayForecast>();

    /**
     *
     * @return
     * The header
     */
    public String getHeader() {
        return header;
    }

    /**
     *
     * @param header
     * The header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     *
     * @return
     * The general
     */
    public String getGeneral() {
        return general;
    }

    /**
     *
     * @param general
     * The general
     */
    public void setGeneral(String general) {
        this.general = general;
    }

    /**
     *
     * @return
     * The zones
     */
    public List<String> getZones() {
        return zones;
    }

    /**
     *
     * @param zones
     * The zones
     */
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    /**
     *
     * @return
     * The reportTime
     */
    public String getReportTime() {
        return reportTime;
    }

    /**
     *
     * @param reportTime
     * The reportTime
     */
    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    /**
     *
     * @return
     * The cities
     */
    public List<String> getCities() {
        return cities;
    }

    /**
     *
     * @param cities
     * The cities
     */
    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    /**
     *
     * @return
     * The zoneNames
     */
    public List<String> getZoneNames() {
        return zoneNames;
    }

    /**
     *
     * @param zoneNames
     * The zoneNames
     */
    public void setZoneNames(List<String> zoneNames) {
        this.zoneNames = zoneNames;
    }

    /**
     *
     * @return
     * The dayForecasts
     */
    public List<DayForecast> getDayForecasts() {
        return dayForecasts;
    }

    /**
     *
     * @param dayForecasts
     * The dayForecasts
     */
    public void setDayForecasts(List<DayForecast> dayForecasts) {
        this.dayForecasts = dayForecasts;
    }

}