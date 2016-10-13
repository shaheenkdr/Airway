package com.devpost.airway.intents;


import com.devpost.airway.Util;

public class Greetings
{
    private static final String good = "Wish you the same, have a good day and fly safe";
    private static final String[] heylo = {"hi","hello"};
    private static final String def = "Hey there, how are you doing?";

    public static String chooseGreetings(String message)
    {
        if(message.contains("morning")||message.contains("evening")||message.contains("night")&&message.contains("good"))
        {
            return good;
        }

        else if(message.contains("hi")||message.contains("hello")||message.contains("hey")||message.contains("hoy"))
        {
            return heylo[Util.getRandom(heylo.length)];
        }
        else
        {
            return def;
        }
    }

}
