package com.devpost.airway.utility;


import java.util.Random;

public class Util
{
    private static final String PLACES_API_KEY = "AIzaSyC3MIBq5vh_xmSHBLg6jCavUEXygbHCbmM";
    private static final String MAPS_API_KEY = "XXX";
    private static final String appID = "93c8de61";
    private static final String key = "3d57c14dfcc5c511cea99d6cf96c172c";
    private static final String CODE_TYPE = "IATA";
    private static final String URL = "XXX";
    public static int getRandom(int num)
    {
        if(num>0)
        {
            Random ran = new Random();
            return ran.nextInt(num);
        }
        else
        {
            return -1;
        }

    }

    public static String getAppId()
    {
        return appID;
    }
    public static String getAppKey()
    {
        return key;
    }

    public static String getCodeType()
    {
        return CODE_TYPE;
    }

    public static String formatUrl(String message)
    {
        if(message.length()>0)
        {
            return message.replaceAll(" ","%20");
        }
        else
        {
            return "";
        }
    }

    public static String getUrl()
    {
        return URL;
    }

    public static String getKeyForPlaces()
    {
        return PLACES_API_KEY;
    }
}
