package com.devpost.airway.flightstats.s.weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Taf {

    @SerializedName("report")
    @Expose
    private String report;
    @SerializedName("reportTime")
    @Expose
    private String reportTime;
    @SerializedName("observationTime")
    @Expose
    private String observationTime;
    @SerializedName("reportType")
    @Expose
    private String reportType;
    @SerializedName("weatherStationIcao")
    @Expose
    private String weatherStationIcao;
    @SerializedName("forecasts")
    @Expose
    private List<Forecast> forecasts = new ArrayList<Forecast>();

    /**
     *
     * @return
     * The report
     */
    public String getReport() {
        return report;
    }

    /**
     *
     * @param report
     * The report
     */
    public void setReport(String report) {
        this.report = report;
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
     * The observationTime
     */
    public String getObservationTime() {
        return observationTime;
    }

    /**
     *
     * @param observationTime
     * The observationTime
     */
    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    /**
     *
     * @return
     * The reportType
     */
    public String getReportType() {
        return reportType;
    }

    /**
     *
     * @param reportType
     * The reportType
     */
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    /**
     *
     * @return
     * The weatherStationIcao
     */
    public String getWeatherStationIcao() {
        return weatherStationIcao;
    }

    /**
     *
     * @param weatherStationIcao
     * The weatherStationIcao
     */
    public void setWeatherStationIcao(String weatherStationIcao) {
        this.weatherStationIcao = weatherStationIcao;
    }

    /**
     *
     * @return
     * The forecasts
     */
    public List<Forecast> getForecasts() {
        return forecasts;
    }

    /**
     *
     * @param forecasts
     * The forecasts
     */
    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

}