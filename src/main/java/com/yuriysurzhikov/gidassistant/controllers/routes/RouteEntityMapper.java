package com.yuriysurzhikov.gidassistant.controllers.routes;

import com.yuriysurzhikov.gidassistant.controllers.place.PlaceEntityMapper;
import com.yuriysurzhikov.gidassistant.controllers.place.PlacesRepository;
import com.yuriysurzhikov.gidassistant.model.client.RouteFromClient;
import com.yuriysurzhikov.gidassistant.model.db.Place;
import com.yuriysurzhikov.gidassistant.model.db.Route;
import com.yuriysurzhikov.gidassistant.utils.EntityMapper;
import kotlin.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class RouteEntityMapper implements EntityMapper<Route, RouteFromClient> {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private PlaceEntityMapper placeEntityMapper;
    @Autowired
    private PlacesRepository placesRepository;

    @Override
    public RouteFromClient mapFromEntity(Route route) {
        return null;
    }

    @Override
    public Pair<Route, Boolean> mapToEntity(RouteFromClient routeFromClient) {
        Route route = null;
        if(routeFromClient.getServerId() != null) {
            route = routeRepository.findRouteById(routeFromClient.getServerId());
        }
        if(route != null) {
            return new Pair<>(route, true);
        } else {
            route = new Route();
            route.id = UUID.randomUUID().toString();
            route.amountPlaces = routeFromClient.getPlaces().size();
            route.places = placeEntityMapper.mapListToEntity(routeFromClient.getPlaces())
                    .parallelStream()
                    .peek(placeBooleanPair -> {
                        if(!placeBooleanPair.component2()){
                            placesRepository.save(placeBooleanPair.component1());
                        }
                    })
                    .map(Pair<Place, Boolean>::component1)
                    .collect(Collectors.toList());
            return new Pair<>(route, false);
        }
    }

    @Override
    public List<Pair<Route, Boolean>> mapListToEntity(List<RouteFromClient> routeFromClients) {
        return routeFromClients.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<RouteFromClient> mapListFromEntity(List<Route> routes) {
        return routes.stream().map(this::mapFromEntity).collect(Collectors.toList());
    }
}
