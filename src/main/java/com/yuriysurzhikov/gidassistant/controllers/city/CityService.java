package com.yuriysurzhikov.gidassistant.controllers.city;

import com.yuriysurzhikov.gidassistant.di.InjectionProvider;
import com.yuriysurzhikov.gidassistant.model.client.CityFromClient;
import com.yuriysurzhikov.gidassistant.model.db.City;
import com.yuriysurzhikov.gidassistant.utils.Const;
import kotlin.Pair;
import org.aspectj.weaver.tools.cache.CacheKeyResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository repository;
    private final CityEntityMapper cityEntityMapper;
    private final CityRepository cityRepository;

    public CityService(CityRepository repository,
                       CityEntityMapper cityEntityMapper,
                       CityRepository cityRepository) {
        this.repository = repository;
        this.cityEntityMapper = cityEntityMapper;
        this.cityRepository = cityRepository;
    }

    public Integer addCityIfNotExists(CityFromClient city) {
        Pair<City, Boolean> cityForSave = cityEntityMapper.mapToEntity(city);
        if(!cityForSave.component2()) {
            cityRepository.save(cityForSave.component1());
            return Const.Repository.SAVE_SUCCESSFUL;
        }
        return Const.Repository.SAVE_FOUND_COINCIDENCE;
    }

    public List<City> getCities(String param) {
        if(Const.City.GET_CITY_TYPE_ALL.equals(param))
            return repository.findAll();
        return repository.findCityByType(param);
    }
}
