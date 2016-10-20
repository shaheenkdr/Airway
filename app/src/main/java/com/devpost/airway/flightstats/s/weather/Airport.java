package com.devpost.airway.flightstats.s.weather;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airport {

    @SerializedName("requestedCode")
    @Expose
    private String requestedCode;
    @SerializedName("fsCode")
    @Expose
    private String fsCode;

    /**
     *
     * @return
     * The requestedCode
     */
    public String getRequestedCode() {
        return requestedCode;
    }

    /**
     *
     * @param requestedCode
     * The requestedCode
     */
    public void setRequestedCode(String requestedCode) {
        this.requestedCode = requestedCode;
    }

    /**
     *
     * @return
     * The fsCode
     */
    public String getFsCode() {
        return fsCode;
    }

    /**
     *
     * @param fsCode
     * The fsCode
     */
    public void setFsCode(String fsCode) {
        this.fsCode = fsCode;
    }

}