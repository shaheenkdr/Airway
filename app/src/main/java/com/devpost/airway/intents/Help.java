package com.devpost.airway.intents;


import com.devpost.airway.utility.ResponseX;
import com.devpost.airway.utility.Util;

public class Help
{
    private static final String[] values = {"oh ho, shall I contact our support team? ","I think I can contact our support team for better assistance,shall I? ","May I make a call to our support team for a better assistance? ","May I contact our support team for further assistance? "};
    private static final String option = "Reply with YES or NO" ;
    private static final int CODE = 5;
    private static String result;


    public static ResponseX chooseHelp()
    {
        result = values[Util.getRandom(values.length)]+option;
        return new ResponseX(CODE,result,9,false);
    }
}
