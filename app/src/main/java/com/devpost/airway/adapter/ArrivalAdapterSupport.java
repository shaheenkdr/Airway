package com.devpost.airway.adapter;


public class ArrivalAdapterSupport
{
    private final double latitude;
    private final double longitude;
    private final String date;
    private final String routeA;
    private final String routeB;
    private final String flightNo;

    public ArrivalAdapterSupport(double latitude,double longitude,String date,String routeA,String routeB,String flightNo)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.routeA = routeA;
        this.routeB = routeB;
        this.flightNo = flightNo;

    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public String getDate()
    {
        return date;
    }

    public String getRouteA()
    {
        return routeA;
    }

    public String getRouteB()
    {
        return routeB;
    }

    public String getFlightNo()
    {
        return flightNo;
    }
}
