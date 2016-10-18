package com.devpost.airway.utility;


import java.util.Random;

public class Util
{
    private static final String PLACES_API_KEY = "AIzaSyC3MIBq5vh_xmSHBLg6jCavUEXygbHCbmM";
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
