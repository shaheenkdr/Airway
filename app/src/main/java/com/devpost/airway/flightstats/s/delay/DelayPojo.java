package com.devpost.airway.flightstats.s.delay;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DelayPojo {

    @SerializedName("request")
    @Expose
    private Request request;
    @SerializedName("delayIndexes")
    @Expose
    private List<DelayIndex> delayIndexes = new ArrayList<DelayIndex>();

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
     * The delayIndexes
     */
    public List<DelayIndex> getDelayIndexes() {
        return delayIndexes;
    }

    /**
     *
     * @param delayIndexes
     * The delayIndexes
     */
    public void setDelayIndexes(List<DelayIndex> delayIndexes) {
        this.delayIndexes = delayIndexes;
    }

}