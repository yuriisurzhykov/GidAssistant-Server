package com.yuriysurzhikov.gidassistant.controllers.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteEntityMapper routeEntityMapper;

    public RouteService(RouteRepository routeRepository, RouteEntityMapper routeEntityMapper) {
        this.routeRepository = routeRepository;
        this.routeEntityMapper = routeEntityMapper;
    }
}
