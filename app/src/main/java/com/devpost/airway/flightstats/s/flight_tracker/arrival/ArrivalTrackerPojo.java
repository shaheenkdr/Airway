
package com.devpost.airway.flightstats.s.flight_tracker.arrival;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArrivalTrackerPojo {

    @SerializedName("request")
    @Expose
    private Request request;
    @SerializedName("appendix")
    @Expose
    private Appendix appendix;
    @SerializedName("flightTracks")
    @Expose
    private List<FlightTrack> flightTracks = new ArrayList<FlightTrack>();

    /**
     * 
     * @return
     *     The request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * 
     * @param request
     *     The request
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * 
     * @return
     *     The appendix
     */
    public Appendix getAppendix() {
        return appendix;
    }

    /**
     * 
     * @param appendix
     *     The appendix
     */
    public void setAppendix(Appendix appendix) {
        this.appendix = appendix;
    }

    /**
     * 
     * @return
     *     The flightTracks
     */
    public List<FlightTrack> getFlightTracks() {
        return flightTracks;
    }

    /**
     * 
     * @param flightTracks
     *     The flightTracks
     */
    public void setFlightTracks(List<FlightTrack> flightTracks) {
        this.flightTracks = flightTracks;
    }

}
