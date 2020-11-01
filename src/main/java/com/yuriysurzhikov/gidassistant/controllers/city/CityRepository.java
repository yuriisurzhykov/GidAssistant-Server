package com.yuriysurzhikov.gidassistant.controllers.city;

import com.yuriysurzhikov.gidassistant.model.db.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {
    City findCityByLatitudeAndLongitudeAndName(Double lat, Double lng, String name);
    List<City> findCityByType(String type);
    City findCityById(String id);
}
