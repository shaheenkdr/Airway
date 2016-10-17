package com.devpost.airway.intents;


import com.devpost.airway.utility.ResponseX;
import com.devpost.airway.utility.Util;

public class None
{
    private static final String[] values = {"oh ho I didn't catch that","I am not trained for that yet ","I do not know that yet "};
    private static final int CODE = 7;
    private static String result;


    public static ResponseX chooseNone()
    {
        result = values[Util.getRandom(values.length)];
        return new ResponseX(CODE,result,0,false);
    }


}
