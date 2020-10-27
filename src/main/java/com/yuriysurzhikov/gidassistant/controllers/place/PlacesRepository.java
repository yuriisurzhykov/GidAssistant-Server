package com.yuriysurzhikov.gidassistant.controllers.place;

import com.yuriysurzhikov.gidassistant.model.db.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Place, String> {
}
