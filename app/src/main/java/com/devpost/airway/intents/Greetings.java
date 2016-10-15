package com.devpost.airway.intents;


import com.devpost.airway.utility.Response;
import com.devpost.airway.utility.Util;

public class Greetings
{
    private static final String good = "Wish you the same, have a good day and fly safe";
    private static final String[] heylo = {"hi","hello"};
    private static final String def = "Hey there, how are you doing?";
    private static final int CODE = 4;
    private static String result;


    public static Response chooseGreetings(String message)
    {
        if(message.contains("morning")||message.contains("evening")||message.contains("night")&&message.contains("good"))
        {
            result = good;
            return new Response(CODE,result,5,false);
        }

        else if(message.contains("hi")||message.contains("hello")||message.contains("hey")||message.contains("hoy"))
        {
            result = heylo[Util.getRandom(heylo.length)];
            return new Response(CODE,result,5,false);
        }
        else
        {
            result = def;
            return new Response(CODE,result,9,false);
        }
    }

}
