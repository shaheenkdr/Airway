package com.devpost.airway.intents;

import com.devpost.airway.utility.ResponseX;

/**
 * Created by oblivion on 10/15/2016.
 */
public class Meditate
{
     private static final int CODE = 6;
     private static String result;

     public static ResponseX chooseMeditate(String message)
     {
          return new ResponseX(CODE,result,9,false);
     }


}
