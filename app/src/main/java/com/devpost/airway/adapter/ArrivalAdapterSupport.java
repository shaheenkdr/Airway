package com.devpost.airway.adapter;


public class ArrivalAdapterSupport
{
    private final double latitude;
    private final double longitude;
    private final String date;
    private final String routeA;
    private final String routeB;
    private final String flightNo;
    private final int speed;
    private final int height;

    public ArrivalAdapterSupport(double latitude,double longitude,String date,String routeA,String routeB,String flightNo,int speed,int height)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.routeA = routeA;
        this.routeB = routeB;
        this.flightNo = flightNo;
        this.speed = speed;
        this.height = height;

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

    public int getSpeed()
    {
        return speed;
    }

    public int getHeight()
    {
        return height;
    }
}
