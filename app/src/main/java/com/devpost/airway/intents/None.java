package com.devpost.airway.intents;


import com.devpost.airway.Util;

public class None
{
    private static final String[] values = {"oh ho I didn't catch that","I am not trained for that yet ","I do not know that yet "};

    public static String chooseNone()
    {
        return values[Util.getRandom(values.length)];
    }


}
