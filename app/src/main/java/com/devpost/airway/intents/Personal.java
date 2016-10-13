package com.devpost.airway.intents;


import com.devpost.airway.Util;

public class Personal
{
    private static final String[] marry = {"I am too young for that","Now you are blushing me"};
    private static final String love = "yes I do, and fly safe :)";
    private static final String parents = "The Airberlin team is my family, they created me and maintains me";
    private static final String def = "Confused,wish I did knew that!";

    public static String choosePersonal(String message)
    {
        if(message.contains("marry")&&message.contains("me"))
        {
            return marry[Util.getRandom(marry.length)];
        }

        else if(message.contains("love")&&message.contains("me"))
        {
            return love;
        }

        else if(message.contains("parents")||message.contains("father")||message.contains("mother")&&message.contains("your"))
        {
            return parents;
        }

        else
        {
            return def;
        }

    }

}
