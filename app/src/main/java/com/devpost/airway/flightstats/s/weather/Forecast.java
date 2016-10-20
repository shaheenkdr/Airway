package com.devpost.airway.flightstats.s.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("conditions")
    @Expose
    private Conditions_ conditions;

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
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
     * The conditions
     */
    public Conditions_ getConditions() {
        return conditions;
    }

    /**
     *
     * @param conditions
     * The conditions
     */
    public void setConditions(Conditions_ conditions) {
        this.conditions = conditions;
    }

}