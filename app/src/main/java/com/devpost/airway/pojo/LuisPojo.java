package com.devpost.airway.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LuisPojo {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("topScoringIntent")
    @Expose
    private TopScoringIntent topScoringIntent;
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
     * The topScoringIntent
     */
    public TopScoringIntent getTopScoringIntent() {
        return topScoringIntent;
    }

    /**
     *
     * @param topScoringIntent
     * The topScoringIntent
     */
    public void setTopScoringIntent(TopScoringIntent topScoringIntent) {
        this.topScoringIntent = topScoringIntent;
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