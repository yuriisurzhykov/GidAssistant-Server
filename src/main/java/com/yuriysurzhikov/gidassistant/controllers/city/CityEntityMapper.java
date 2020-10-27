package com.yuriysurzhikov.gidassistant.controllers.city;

import com.yuriysurzhikov.gidassistant.model.client.CityFromClient;
import com.yuriysurzhikov.gidassistant.model.db.City;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;

public class CityEntityMapper implements EntityMapper<City, CityFromClient> {
    @Override
    public CityFromClient mapFromEntity(City city) {
        return null;
    }

    @Override
    public City mapToEntity(CityFromClient cityFromClient) {
        return null;
    }
}
