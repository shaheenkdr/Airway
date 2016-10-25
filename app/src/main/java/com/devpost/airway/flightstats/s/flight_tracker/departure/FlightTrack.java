
package com.devpost.airway.flightstats.s.flight_tracker.departure;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightTrack {

    @SerializedName("flightId")
    @Expose
    private Integer flightId;
    @SerializedName("carrierFsCode")
    @Expose
    private String carrierFsCode;
    @SerializedName("flightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("tailNumber")
    @Expose
    private String tailNumber;
    @SerializedName("departureAirportFsCode")
    @Expose
    private String departureAirportFsCode;
    @SerializedName("arrivalAirportFsCode")
    @Expose
    private String arrivalAirportFsCode;
    @SerializedName("departureDate")
    @Expose
    private DepartureDate departureDate;
    @SerializedName("equipment")
    @Expose
    private String equipment;
    @SerializedName("bearing")
    @Expose
    private Double bearing;
    @SerializedName("heading")
    @Expose
    private Double heading;
    @SerializedName("positions")
    @Expose
    private List<Position> positions = new ArrayList<Position>();

    /**
     * 
     * @return
     *     The flightId
     */
    public Integer getFlightId() {
        return flightId;
    }

    /**
     * 
     * @param flightId
     *     The flightId
     */
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    /**
     * 
     * @return
     *     The carrierFsCode
     */
    public String getCarrierFsCode() {
        return carrierFsCode;
    }

    /**
     * 
     * @param carrierFsCode
     *     The carrierFsCode
     */
    public void setCarrierFsCode(String carrierFsCode) {
        this.carrierFsCode = carrierFsCode;
    }

    /**
     * 
     * @return
     *     The flightNumber
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * 
     * @param flightNumber
     *     The flightNumber
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * 
     * @return
     *     The tailNumber
     */
    public String getTailNumber() {
        return tailNumber;
    }

    /**
     * 
     * @param tailNumber
     *     The tailNumber
     */
    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    /**
     * 
     * @return
     *     The departureAirportFsCode
     */
    public String getDepartureAirportFsCode() {
        return departureAirportFsCode;
    }

    /**
     * 
     * @param departureAirportFsCode
     *     The departureAirportFsCode
     */
    public void setDepartureAirportFsCode(String departureAirportFsCode) {
        this.departureAirportFsCode = departureAirportFsCode;
    }

    /**
     * 
     * @return
     *     The arrivalAirportFsCode
     */
    public String getArrivalAirportFsCode() {
        return arrivalAirportFsCode;
    }

    /**
     * 
     * @param arrivalAirportFsCode
     *     The arrivalAirportFsCode
     */
    public void setArrivalAirportFsCode(String arrivalAirportFsCode) {
        this.arrivalAirportFsCode = arrivalAirportFsCode;
    }

    /**
     * 
     * @return
     *     The departureDate
     */
    public DepartureDate getDepartureDate() {
        return departureDate;
    }

    /**
     * 
     * @param departureDate
     *     The departureDate
     */
    public void setDepartureDate(DepartureDate departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * 
     * @return
     *     The equipment
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * 
     * @param equipment
     *     The equipment
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * 
     * @return
     *     The bearing
     */
    public Double getBearing() {
        return bearing;
    }

    /**
     * 
     * @param bearing
     *     The bearing
     */
    public void setBearing(Double bearing) {
        this.bearing = bearing;
    }

    /**
     * 
     * @return
     *     The heading
     */
    public Double getHeading() {
        return heading;
    }

    /**
     * 
     * @param heading
     *     The heading
     */
    public void setHeading(Double heading) {
        this.heading = heading;
    }

    /**
     * 
     * @return
     *     The positions
     */
    public List<Position> getPositions() {
        return positions;
    }

    /**
     * 
     * @param positions
     *     The positions
     */
    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

}
