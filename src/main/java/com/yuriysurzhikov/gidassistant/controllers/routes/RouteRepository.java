package com.yuriysurzhikov.gidassistant.controllers.routes;


import com.yuriysurzhikov.gidassistant.model.db.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, String> {
    Route findRouteById(String id);
}
