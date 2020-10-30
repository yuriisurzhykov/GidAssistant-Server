package com.yuriysurzhikov.gidassistant.controllers.city;

import com.yuriysurzhikov.gidassistant.di.InjectionProvider;
import com.yuriysurzhikov.gidassistant.model.client.CityFromClient;
import com.yuriysurzhikov.gidassistant.model.db.City;
import com.yuriysurzhikov.gidassistant.utils.Const;
import org.aspectj.weaver.tools.cache.CacheKeyResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository repository;
    private final CityEntityMapper cityEntityMapper;

    public CityService(CityRepository repository, CityEntityMapper cityEntityMapper) {
        this.repository = repository;
        this.cityEntityMapper = cityEntityMapper;
    }

    public Integer addCityIfNotExists(CityFromClient city) {
        City cityForSave = cityEntityMapper.mapToEntity(city);
        City city1 = repository.findCityByLatitudeAndLongitudeAndName(cityForSave.latitude, cityForSave.longitude, cityForSave.name);
        if(city1 == null) {
            repository.save(cityForSave);
            return Const.Repository.SAVE_SUCCESSFUL;
        } else {
            return Const.Repository.SAVE_FOUND_COINCIDENCE;
        }
    }

    public List<City> getCities(String param) {
        if(Const.City.GET_CITY_TYPE_ALL.equals(param))
            return repository.findAll();
        return repository.findCityByType(param);
    }
}
