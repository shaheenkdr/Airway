package com.devpost.airway.utility;


import java.util.Random;

public class Util
{
    private static final String PLACES_API_KEY = "AIzaSyC3MIBq5vh_xmSHBLg6jCavUEXygbHCbmM";
    private static final String MAPS_API_KEY = "AIzaSyCdix9RXZGii8K9ox5mldGY5EUl84CIqc4";
    private static final String appID = "c38a36d1";
    private static final String key = "0a1934e7a2d2ad2a82f00feb985c5945";
    private static final String CODE_TYPE = "IATA";
    private static final String URL = "https://api.projectoxford.ai/luis/v1/application?id=44e80599-c74c-4bc7-b30e-41730a6adfb2&subscription-key=3c12c7fd5d4c408ab856288e695ee5f7&q=";
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
