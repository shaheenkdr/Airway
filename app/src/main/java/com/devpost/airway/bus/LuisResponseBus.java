package com.devpost.airway.bus;


public class LuisResponseBus
{
    private final String INTENT_NAME;
    private final String ORIGINAL_MESSAGE;

    public LuisResponseBus(String INTENT_NAME,String ORIGINAL_MESSAGE)
    {
        this.INTENT_NAME = INTENT_NAME;
        this.ORIGINAL_MESSAGE = ORIGINAL_MESSAGE;
    }

    public String getIntentName()
    {
        return INTENT_NAME;
    }

    public String getOriginalMessage()
    {
        return ORIGINAL_MESSAGE;
    }

}
