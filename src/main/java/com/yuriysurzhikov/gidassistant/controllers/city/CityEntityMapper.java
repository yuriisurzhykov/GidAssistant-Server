package com.yuriysurzhikov.gidassistant.controllers.city;

import com.yuriysurzhikov.gidassistant.model.client.CityFromClient;
import com.yuriysurzhikov.gidassistant.model.db.City;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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
    public City mapToEntity(CityFromClient cityFromClient) {
        City city;
        if((city = cityRepository.findCityById(cityFromClient.getServerId())) != null) {
            city = new City();
            city.id = UUID.randomUUID().toString();
            city.name = cityFromClient.getName();
            city.latitude = cityFromClient.getLatitude();
            city.longitude = cityFromClient.getLongitude();
            city.googleUrl = cityFromClient.getGoogleUrl();
            city.type = cityFromClient.getType();
        }
        return city;
    }

    @Override
    public List<City> mapListToEntity(List<CityFromClient> cityFromClients) {
        return cityFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<CityFromClient> mapListFromEntity(List<City> cities) {
        return cities.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
