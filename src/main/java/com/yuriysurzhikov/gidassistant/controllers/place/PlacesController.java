package com.yuriysurzhikov.gidassistant.controllers.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/place")
public class PlacesController {

    @Autowired
    private PlacesService placesService;
}
