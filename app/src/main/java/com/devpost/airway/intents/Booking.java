package com.devpost.airway.intents;


import com.devpost.airway.Util;

import java.util.concurrent.ThreadLocalRandom;

public class Booking
{
    private static final String[] values = {"Would you like to book an air ticket? ", "Shall I help you to book a flight ticket? ","Can I book an air ticket for you"};
    private static final String option = "Reply with YES or NO" ;
    private static final String[] discount = {"Shall I help you choose a cheap flight ticket? ", "Would you like to book an air ticket with discount? "};
    private static String result;

    public static String chooseBooking(String message)
    {

        if(message.contains("discount")||message.contains("cheap"))
        {
            result = discount[Util.getRandom(discount.length)]+option;
            return result;
        }

        else
        {
            result = values[Util.getRandom(values.length)]+option;
            return result;
        }
    }

}
