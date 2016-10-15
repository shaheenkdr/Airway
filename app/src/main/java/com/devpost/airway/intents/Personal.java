package com.devpost.airway.intents;


import com.devpost.airway.utility.Response;
import com.devpost.airway.utility.Util;

public class Personal
{
    private static final String[] marry = {"I am too young for that","Now you are blushing me"};
    private static final String love = "yes I do, and fly safe :)";
    private static final String parents = "The Airberlin team is my family, they created me and maintains me";
    private static final String def = "Confused,wish I did knew that!";
    private static final int CODE = 8;
    private static String result;


    public static Response choosePersonal(String message)
    {
        if(message.contains("marry")&&message.contains("me"))
        {
            result = marry[Util.getRandom(marry.length)];
            return new Response(CODE,result,0,false);
        }

        else if(message.contains("love")&&message.contains("me"))
        {
            result = love;
            return new Response(CODE,result,0,false);

        }

        else if(message.contains("parents")||message.contains("father")||message.contains("mother")&&message.contains("your"))
        {
            result = parents;
            return new Response(CODE,result,0,false);

        }

        else
        {
            result = def;
            return new Response(CODE,result,0,false);
        }

    }

}
