package com.yuriysurzhikov.gidassistant.controllers.routes;


import com.gidassistant.server.model.server.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, String> {
}
