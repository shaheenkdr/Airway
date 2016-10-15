package com.devpost.airway.utility;


public class Text
{
    private String message;
    private boolean machine_or_human;

    public Text(String message,boolean machine_or_human)
    {
        this.message = message;
        this.machine_or_human = machine_or_human;
    }

    public String getMessage()
    {
        return message;
    }

    public boolean isMachineOrHuman()
    {
        return machine_or_human;
    }
}
