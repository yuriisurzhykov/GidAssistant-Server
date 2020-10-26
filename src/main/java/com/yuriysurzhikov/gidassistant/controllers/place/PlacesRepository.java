package com.yuriysurzhikov.gidassistant.controllers.place;

import com.gidassistant.server.model.server.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Place, String> {
}
