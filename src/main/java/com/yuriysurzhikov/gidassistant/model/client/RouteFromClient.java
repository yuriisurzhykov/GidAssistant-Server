package com.yuriysurzhikov.gidassistant.model.client;

import java.util.ArrayList;
import java.util.List;

public class RouteFromClient {

    private String serverId;
    private String name;
    private Integer amountPlaces;
    private Long routeLengthM;
    private List<PlaceFromClient> places = new ArrayList<>();

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountPlaces() {
        return amountPlaces;
    }

    public void setAmountPlaces(Integer amountPlaces) {
        this.amountPlaces = amountPlaces;
    }

    public Long getRouteLengthM() {
        return routeLengthM;
    }

    public void setRouteLengthM(Long routeLengthM) {
        this.routeLengthM = routeLengthM;
    }

    public List<PlaceFromClient> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceFromClient> places) {
        this.places = places;
    }
}
