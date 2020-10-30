package com.yuriysurzhikov.gidassistant.model.client;

import com.yuriysurzhikov.gidassistant.model.db.Interest;
import com.yuriysurzhikov.gidassistant.model.db.Route;

import java.util.ArrayList;
import java.util.List;

public class PlaceFromClient {

    private String serverId;
    private String name;
    private String description;
    private String googleUrl;
    private String photoUrl;
    private Double latitude;
    private Double longitude;
    private List<InterestFromClient> interests = new ArrayList<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<InterestFromClient> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestFromClient> interests) {
        this.interests = interests;
    }
}
