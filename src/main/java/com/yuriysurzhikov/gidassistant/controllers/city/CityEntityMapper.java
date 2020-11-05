package com.yuriysurzhikov.gidassistant.controllers.city;

import com.yuriysurzhikov.gidassistant.model.client.CityFromClient;
import com.yuriysurzhikov.gidassistant.model.db.City;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class CityEntityMapper implements EntityMapper<City, CityFromClient> {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public CityFromClient mapFromEntity(City city) {
        return null;
    }

    @Override
    public Pair<City, Boolean> mapToEntity(CityFromClient cityFromClient) {
        City city = null;
        if(cityFromClient.getServerId() != null) {
            city = cityRepository.findCityById(cityFromClient.getServerId());
        }
        if(city != null) {
            return new Pair<>(city, true);
        } else {
            city = new City();
            city.id = UUID.randomUUID().toString();
            city.name = cityFromClient.getName();
            city.latitude = cityFromClient.getLatitude();
            city.longitude = cityFromClient.getLongitude();
            city.googleUrl = cityFromClient.getGoogleUrl();
            city.type = cityFromClient.getType();
            return new Pair<>(city, false);
        }
    }

    @Override
    public List<Pair<City, Boolean>> mapListToEntity(List<CityFromClient> cityFromClients) {
        return cityFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<CityFromClient> mapListFromEntity(List<City> cities) {
        return cities.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
