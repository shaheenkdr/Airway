package com.devpost.airway.flightstats.s.weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metar {

    @SerializedName("report")
    @Expose
    private String report;
    @SerializedName("reportTime")
    @Expose
    private String reportTime;
    @SerializedName("weatherStationIcao")
    @Expose
    private String weatherStationIcao;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @SerializedName("conditions")
    @Expose
    private Conditions conditions;
    @SerializedName("temperatureCelsius")
    @Expose
    private String temperatureCelsius;
    @SerializedName("dewPointCelsius")
    @Expose
    private String dewPointCelsius;
    @SerializedName("runwayVisualRanges")
    @Expose
    private List<Object> runwayVisualRanges = new ArrayList<Object>();
    @SerializedName("obscurations")
    @Expose
    private List<Object> obscurations = new ArrayList<Object>();
    @SerializedName("noSignificantChange")
    @Expose
    private Boolean noSignificantChange;

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
     * The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     * The tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     * The conditions
     */
    public Conditions getConditions() {
        return conditions;
    }

    /**
     *
     * @param conditions
     * The conditions
     */
    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    /**
     *
     * @return
     * The temperatureCelsius
     */
    public String getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     *
     * @param temperatureCelsius
     * The temperatureCelsius
     */
    public void setTemperatureCelsius(String temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    /**
     *
     * @return
     * The dewPointCelsius
     */
    public String getDewPointCelsius() {
        return dewPointCelsius;
    }

    /**
     *
     * @param dewPointCelsius
     * The dewPointCelsius
     */
    public void setDewPointCelsius(String dewPointCelsius) {
        this.dewPointCelsius = dewPointCelsius;
    }

    /**
     *
     * @return
     * The runwayVisualRanges
     */
    public List<Object> getRunwayVisualRanges() {
        return runwayVisualRanges;
    }

    /**
     *
     * @param runwayVisualRanges
     * The runwayVisualRanges
     */
    public void setRunwayVisualRanges(List<Object> runwayVisualRanges) {
        this.runwayVisualRanges = runwayVisualRanges;
    }

    /**
     *
     * @return
     * The obscurations
     */
    public List<Object> getObscurations() {
        return obscurations;
    }

    /**
     *
     * @param obscurations
     * The obscurations
     */
    public void setObscurations(List<Object> obscurations) {
        this.obscurations = obscurations;
    }

    /**
     *
     * @return
     * The noSignificantChange
     */
    public Boolean getNoSignificantChange() {
        return noSignificantChange;
    }

    /**
     *
     * @param noSignificantChange
     * The noSignificantChange
     */
    public void setNoSignificantChange(Boolean noSignificantChange) {
        this.noSignificantChange = noSignificantChange;
    }

}