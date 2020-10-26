package com.yuriysurzhikov.gidassistant.controllers.place;

import com.yuriysurzhikov.gidassistant.model.client.PlaceFromClient;
import com.yuriysurzhikov.gidassistant.model.server.Place;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;

public class PlaceEntityMapper implements EntityMapper<Place, PlaceFromClient> {
    @Override
    public PlaceFromClient mapFromEntity(Place place) {
        return null;
    }

    @Override
    public Place mapToEntity(PlaceFromClient placeFromClient) {
        return null;
    }
}
