
package com.devpost.airway.flightstats.s.flight_tracker.departure;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position {

    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("speedMph")
    @Expose
    private Integer speedMph;
    @SerializedName("altitudeFt")
    @Expose
    private Integer altitudeFt;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("date")
    @Expose
    private String date;

    /**
     * 
     * @return
     *     The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The speedMph
     */
    public Integer getSpeedMph() {
        return speedMph;
    }

    /**
     * 
     * @param speedMph
     *     The speedMph
     */
    public void setSpeedMph(Integer speedMph) {
        this.speedMph = speedMph;
    }

    /**
     * 
     * @return
     *     The altitudeFt
     */
    public Integer getAltitudeFt() {
        return altitudeFt;
    }

    /**
     * 
     * @param altitudeFt
     *     The altitudeFt
     */
    public void setAltitudeFt(Integer altitudeFt) {
        this.altitudeFt = altitudeFt;
    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

}
