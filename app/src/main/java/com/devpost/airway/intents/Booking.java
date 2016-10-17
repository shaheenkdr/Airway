package com.devpost.airway.intents;


import com.devpost.airway.utility.ResponseX;
import com.devpost.airway.utility.Util;

public class Booking
{
    private static final String[] values = {"Would you like to book an air ticket? ", "Shall I help you to book a flight ticket? ","Can I book an air ticket for you"};
    private static final String option = "Reply with YES or NO" ;
    private static final String[] discount = {"Shall I help you choose a cheap flight ticket? ", "Would you like to book an air ticket with discount? "};
    private static String result;
    private static final int CODE = 1;

    public static ResponseX chooseBooking(String message)
    {

        if(message.contains("discount")||message.contains("cheap"))
        {
            result = discount[Util.getRandom(discount.length)]+option;
            return new ResponseX(CODE,result,9,false);
        }

        else
        {
            result = values[Util.getRandom(values.length)]+option;
            return new ResponseX(CODE,result,9,false);
        }
    }

}
