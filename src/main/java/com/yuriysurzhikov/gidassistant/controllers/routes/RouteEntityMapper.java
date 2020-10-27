package com.yuriysurzhikov.gidassistant.controllers.routes;

import com.yuriysurzhikov.gidassistant.model.client.RouteFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Route;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;

public class RouteEntityMapper implements EntityMapper<Route, RouteFromClient> {
    @Override
    public RouteFromClient mapFromEntity(Route route) {
        return null;
    }

    @Override
    public Route mapToEntity(RouteFromClient routeFromClient) {
        return null;
    }
}
