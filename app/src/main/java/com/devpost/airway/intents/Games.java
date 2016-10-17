package com.devpost.airway.intents;


import com.devpost.airway.utility.ResponseX;
import com.devpost.airway.utility.Util;

public class Games
{
    private static final String[] values = {"Would you like to play some games? "," How about we play some games? ","I think playing some games should be fun, what do you think? ","oh,will you play games with me for some time? ","I think playing games should be fun, what do you think? ","Time to play some games then, shall we? "};
    private static final String option = "Reply with YES or NO" ;
    private static String result;
    private static final int CODE = 3;


    public static ResponseX chooseGames(String message)
    {
        result = values[Util.getRandom(values.length)]+option;
        return new ResponseX(CODE,result,9,false);
    }

}
