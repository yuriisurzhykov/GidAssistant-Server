package com.yuriysurzhikov.gidassistant.controllers.place;

import com.gidassistant.server.model.client.PlaceFromClient;
import com.gidassistant.server.model.server.Place;
import com.gidassistant.server.utils.EntityMapper;

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
