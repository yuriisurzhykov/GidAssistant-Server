package com.yuriysurzhikov.gidassistant.controllers.routes;

import com.yuriysurzhikov.gidassistant.model.client.RouteFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Route;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;

import java.util.List;
import java.util.stream.Collectors;

public class RouteEntityMapper implements EntityMapper<Route, RouteFromClient> {
    @Override
    public RouteFromClient mapFromEntity(Route route) {
        return null;
    }

    @Override
    public Route mapToEntity(RouteFromClient routeFromClient) {
        return null;
    }

    @Override
    public List<Route> mapListToEntity(List<RouteFromClient> routeFromClients) {
        return routeFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<RouteFromClient> mapListFromEntity(List<Route> routes) {
        return routes.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
