package com.devpost.airway.utility;


public class Response
{
    private final int EVENT_ID_TAG;
    private final String RESPONSE;
    private final int RESPONSE_TYPE_CODE;
    private final boolean REPEATED;

    public Response(int EVENT_ID_TAG,String RESPONSE,int RESPONSE_TYPE_CODE,boolean REPEATED)
    {
        this.EVENT_ID_TAG = EVENT_ID_TAG;
        this.RESPONSE = RESPONSE;
        this.RESPONSE_TYPE_CODE = RESPONSE_TYPE_CODE;
        this.REPEATED = REPEATED;
    }

    public int getEventIdTag()
    {
        return EVENT_ID_TAG;
    }

    public String getResponse()
    {
        return RESPONSE;
    }

    /**
     * RESPONSE_TYPE_CODE : 0  -- DO NOT LISTEN FOR REPLY
     * RESPONSE_TYPE_CODE : 5  -- OPTIONALLY LISTEN FOR REPLY
     * RESPONSE_TYPE_CODE : 9  -- MUST LISTEN FOR REPLY
     */

    public int getResponseTypeCode()
    {
        return RESPONSE_TYPE_CODE;
    }

    public boolean isRepeatedFromUser()
    {
        return REPEATED;
    }
}
