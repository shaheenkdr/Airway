package com.devpost.airway.flightstats.s.weather;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Visibility {

    @SerializedName("miles")
    @Expose
    private String miles;
    @SerializedName("lessThan")
    @Expose
    private Boolean lessThan;
    @SerializedName("cavok")
    @Expose
    private Boolean cavok;

    /**
     *
     * @return
     * The miles
     */
    public String getMiles() {
        return miles;
    }

    /**
     *
     * @param miles
     * The miles
     */
    public void setMiles(String miles) {
        this.miles = miles;
    }

    /**
     *
     * @return
     * The lessThan
     */
    public Boolean getLessThan() {
        return lessThan;
    }

    /**
     *
     * @param lessThan
     * The lessThan
     */
    public void setLessThan(Boolean lessThan) {
        this.lessThan = lessThan;
    }

    /**
     *
     * @return
     * The cavok
     */
    public Boolean getCavok() {
        return cavok;
    }

    /**
     *
     * @param cavok
     * The cavok
     */
    public void setCavok(Boolean cavok) {
        this.cavok = cavok;
    }

}