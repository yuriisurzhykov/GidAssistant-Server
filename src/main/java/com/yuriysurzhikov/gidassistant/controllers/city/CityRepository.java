package com.yuriysurzhikov.gidassistant.controllers.city;

import com.yuriysurzhikov.gidassistant.model.db.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {
}
