package com.yuriysurzhikov.gidassistant.controllers.place;

import org.springframework.stereotype.Service;

@Service
public class PlacesService {

    private final PlacesRepository placesRepository;

    public PlacesService(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }
}
