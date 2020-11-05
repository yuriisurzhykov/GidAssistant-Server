package com.yuriysurzhikov.gidassistant.controllers.place;

import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.interests.InterestsRepository;
import com.yuriysurzhikov.gidassistant.controllers.routes.RouteEntityMapper;
import com.yuriysurzhikov.gidassistant.model.client.PlaceFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Interest;
import com.yuriysurzhikov.gidassistant.model.db.Place;
import com.yuriysurzhikov.gidassistant.model.db.Route;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class PlaceEntityMapper implements EntityMapper<Place, PlaceFromClient> {

    @Autowired
    private InterestsEntityMapper interestsEntityMapper;
    @Autowired
    private RouteEntityMapper routeEntityMapper;
    @Autowired
    private PlacesRepository placesRepository;
    @Autowired
    private InterestsRepository interestsRepository;

    @Override
    public PlaceFromClient mapFromEntity(Place place) {
        return null;
    }

    @Override
    public Pair<Place, Boolean> mapToEntity(PlaceFromClient placeFromClient) {
        Place place = null;
        if (placeFromClient.getServerId() != null) {
            place = placesRepository.getOne(placeFromClient.getServerId());
        }
        if (place != null) {
            return new Pair<>(place, true);
        } else {
            place = new Place();
            place.id = UUID.randomUUID().toString();
            place.longitude = placeFromClient.getLongitude();
            place.latitude = placeFromClient.getLatitude();
            place.description = placeFromClient.getDescription();
            place.googleUrl = placeFromClient.getGoogleUrl();
            place.photoUrl = placeFromClient.getPhotoUrl();
            place.interests = interestsEntityMapper
                    .mapListToEntity(placeFromClient.getInterests())
                    .parallelStream()
                    .peek(interestBooleanPair -> {
                        if (!interestBooleanPair.component2()) {
                            interestsRepository.save(interestBooleanPair.component1());
                        }
                    })
                    .map(Pair::component1)
                    .collect(Collectors.toList());
            place.routes = null;
            return new Pair<>(place, false);
        }
    }

    @Override
    public List<Pair<Place, Boolean>> mapListToEntity(List<PlaceFromClient> placeFromClients) {
        return placeFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<PlaceFromClient> mapListFromEntity(List<Place> places) {
        return places.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
