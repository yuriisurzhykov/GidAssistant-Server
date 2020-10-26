package com.yuriysurzhikov.gidassistant.controllers.routes;

import com.gidassistant.server.model.client.RouteFromClient;
import com.gidassistant.server.model.server.Route;
import com.gidassistant.server.utils.EntityMapper;

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
