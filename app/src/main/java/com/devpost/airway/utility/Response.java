package com.devpost.airway.utility;


public class Response
{
    private final int EVENT_ID_TAG;
    private final String RESPONSE;
    private final int RESPONSE_TYPE_CODE;

    public Response(int EVENT_ID_TAG,String RESPONSE,int RESPONSE_TYPE_CODE)
    {
        this.EVENT_ID_TAG = EVENT_ID_TAG;
        this.RESPONSE = RESPONSE;
        this.RESPONSE_TYPE_CODE = RESPONSE_TYPE_CODE;
    }

    public int getEventIdTag()
    {
        return EVENT_ID_TAG;
    }

    public String getResponse()
    {
        return RESPONSE;
    }

    public int getResponseTypeCode()
    {
        return RESPONSE_TYPE_CODE;
    }
}
