package com.devpost.airway.flightstats.s.weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DayForecast {

    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("forecast")
    @Expose
    private String forecast;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("tags")
    @Expose
    private List<Tag_> tags = new ArrayList<Tag_>();

    /**
     *
     * @return
     * The day
     */
    public String getDay() {
        return day;
    }

    /**
     *
     * @param day
     * The day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     *
     * @return
     * The forecast
     */
    public String getForecast() {
        return forecast;
    }

    /**
     *
     * @param forecast
     * The forecast
     */
    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    /**
     *
     * @return
     * The start
     */
    public String getStart() {
        return start;
    }

    /**
     *
     * @param start
     * The start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     *
     * @return
     * The end
     */
    public String getEnd() {
        return end;
    }

    /**
     *
     * @param end
     * The end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     *
     * @return
     * The tags
     */
    public List<Tag_> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     * The tags
     */
    public void setTags(List<Tag_> tags) {
        this.tags = tags;
    }

}