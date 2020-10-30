package com.yuriysurzhikov.gidassistant.controllers.place;

import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.routes.RouteEntityMapper;
import com.yuriysurzhikov.gidassistant.model.client.PlaceFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Place;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PlaceEntityMapper implements EntityMapper<Place, PlaceFromClient> {

    @Autowired
    private InterestsEntityMapper interestsEntityMapper;
    @Autowired
    private RouteEntityMapper routeEntityMapper;
    @Autowired
    private PlacesRepository placesRepository;

    @Override
    public PlaceFromClient mapFromEntity(Place place) {
        return null;
    }

    @Override
    public Place mapToEntity(PlaceFromClient placeFromClient) {
        Place place = new Place();
        if(placeFromClient.getServerId() != null) {
            place = placesRepository.getOne(placeFromClient.getServerId());
        } else {
            place.id = UUID.randomUUID().toString();
            place.longitude = placeFromClient.getLongitude();
            place.latitude = placeFromClient.getLatitude();
            place.description = placeFromClient.getDescription();
            place.googleUrl = placeFromClient.getGoogleUrl();
            place.photoUrl = placeFromClient.getPhotoUrl();
            place.interests = interestsEntityMapper.mapListToEntity(placeFromClient.getInterests());
            place.routes = null;
        }
        return place;
    }

    @Override
    public List<Place> mapListToEntity(List<PlaceFromClient> placeFromClients) {
        return placeFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<PlaceFromClient> mapListFromEntity(List<Place> places) {
        return places.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
