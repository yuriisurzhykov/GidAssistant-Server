package com.yuriysurzhikov.gidassistant.controllers.place;

import com.yuriysurzhikov.gidassistant.model.server.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Place, String> {
}
