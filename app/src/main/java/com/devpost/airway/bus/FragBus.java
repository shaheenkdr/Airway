package com.devpost.airway.bus;

public class FragBus
{
    private final String url_dep;

    public FragBus(String url_dep)
    {
        this.url_dep = url_dep;
    }

    public String getUrlDep()
    {
        return url_dep;
    }
}
