package com.devpost.airway.intents;


import com.devpost.airway.Util;

public class Games
{
    private static final String[] values = {"Would you like to play some games? "," How about we play some games? ","I think playing some games should be fun, what do you think? ","oh,will you play games with me for some time? ","I think playing games should be fun, what do you think? ","Time to play some games then, shall we? "};
    private static final String option = "Reply with YES or NO" ;

    public static String chooseGames(String message)
    {
        return values[Util.getRandom(values.length)]+option;
    }

}
