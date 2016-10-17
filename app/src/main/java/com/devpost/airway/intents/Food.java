package com.devpost.airway.intents;


import com.devpost.airway.utility.ResponseX;
import com.devpost.airway.utility.Util;

public class Food
{
    private static String result;
    private static final int CODE = 2;
    private static final String[] values = {"Would you like to see the nearby hotels? ", "Shall I find the best restaurants nearby? ", "May I search for the finest restaurants here? ","May I show you the best place to get the best food here? ","I can find the best restaurants for you,shall I ? ","I can help you find the best food out here, may I try "};
    private static final String option = "Reply with YES or NO" ;
    private static final String[] dinner_values = {"Would you like to see the nearby hotels that serves dinner ","Shall I find the best restaurants nearby that serves dinner ","May I search for the finest restaurants here that serves the best dinner "};
    private static final String[] lunch_values = {"Would you like to see the nearby hotels that serves lunch ","Shall I find the best restaurants nearby that serves lunch ","May I search for the finest restaurants here that serves the best lunch "};
    private static final String[] breakfast_values = {"Would you like to see the nearby hotels that serves breakfast ","Shall I find the best restaurants nearby that serves breakfast ","May I search for the finest restaurants here that serves the best breakfast "};

    public static ResponseX chooseFood(String message)
    {
        if(message.contains("dinner")&&!message.contains("lunch")&&!message.contains("breakfast"))
        {
            result = dinner_values[Util.getRandom(dinner_values.length)]+option;
            return new ResponseX(CODE,result,9,false);

        }
        else if(message.contains("breakfast")&&!message.contains("dinner")&&!message.contains("lunch"))
        {
            result = breakfast_values[Util.getRandom(breakfast_values.length)]+option;
            return new ResponseX(CODE,result,9,false);

        }
        else if(message.contains("lunch")&&!message.contains("breakfast")&&!message.contains("dinner"))
        {
            result = lunch_values[Util.getRandom(lunch_values.length)]+option;
            return new ResponseX(CODE,result,9,false);


        }
        else
        {
            result = values[Util.getRandom(values.length)]+option;
            return new ResponseX(CODE,result,9,false);
        }
    }
}
