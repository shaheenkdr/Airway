package com.devpost.airway.intents;


import com.devpost.airway.utility.Util;

public class Places
{
    private static final String[] values = {"Shall I suggest you a nice place to travel? ","How about I choose an awesome place to tour? ","I know a perfect place for a vacation,would you like to know? ","How about we travel to a heavenly place?Excited? ","I know a perfect place that's a must visit,like to know? "};
    private static final String option = "Reply with YES or NO" ;
    private static final int CODE = 9;


    public static String choosePlace()
    {
        return values[Util.getRandom(values.length)]+option;
    }



}
