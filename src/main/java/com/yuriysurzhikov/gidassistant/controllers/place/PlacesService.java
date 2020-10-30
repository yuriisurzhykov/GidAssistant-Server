package com.yuriysurzhikov.gidassistant.controllers.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacesService {

    private final PlacesRepository placesRepository;
    private final PlaceEntityMapper placeEntityMapper;

    public PlacesService(PlacesRepository placesRepository, PlaceEntityMapper placeEntityMapper) {
        this.placesRepository = placesRepository;
        this.placeEntityMapper = placeEntityMapper;
    }
}
