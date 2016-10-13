package com.devpost.airway;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LuisPojo {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("intents")
    @Expose
    private List<IntentX> intents = new ArrayList<IntentX>();
    @SerializedName("entities")
    @Expose
    private List<Object> entities = new ArrayList<Object>();

    /**
     *
     * @return
     * The query
     */
    public String getQuery() {
        return query;
    }

    /**
     *
     * @param query
     * The query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     *
     * @return
     * The intents
     */
    public List<IntentX> getIntents() {
        return intents;
    }

    /**
     *
     * @param intents
     * The intents
     */
    public void setIntents(List<IntentX> intents) {
        this.intents = intents;
    }

    /**
     *
     * @return
     * The entities
     */
    public List<Object> getEntities() {
        return entities;
    }

    /**
     *
     * @param entities
     * The entities
     */
    public void setEntities(List<Object> entities) {
        this.entities = entities;
    }

}